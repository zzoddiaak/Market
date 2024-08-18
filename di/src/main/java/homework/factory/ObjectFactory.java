package homework.factory;

import homework.annotations.Autowired;
import homework.config.ObjectConfig;
import homework.context.ApplicationContext;
import homework.exeption.ObjectInstantiationException;

import javax.annotation.PostConstruct;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {
    private final ApplicationContext context;
    private List<ObjectConfig> configurators = new ArrayList<>();

    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        for (Class<? extends ObjectConfig> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfig.class)) {
            try {
                configurators.add(aClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new ObjectInstantiationException("Failed to instantiate ObjectConfig", e);
            }
        }
    }

    public <T> T createObject(Class<T> implClass) {
        T t = create(implClass);
        configure(t);
        invokeInit(implClass, t);
        return t;
    }

    private <T> void configure(T t) {
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t, context));
    }

    private <T> List<Constructor<T>> getAutowiredConstructors(Class<T> implClass) {
        List<Constructor<T>> autowiredConstructors = new ArrayList<>();
        for (Constructor<?> constructor : implClass.getDeclaredConstructors()) {
            if (constructor.isAnnotationPresent(Autowired.class)) {
                autowiredConstructors.add((Constructor<T>) constructor);
            }
        }
        return autowiredConstructors;
    }

    private <T> T create(Class<T> implClass) {
        List<Constructor<T>> autowiredConstructors = getAutowiredConstructors(implClass);
        if (!autowiredConstructors.isEmpty()) {
            return createWithAutowiredConstructor(autowiredConstructors.get(0));
        } else {
            return createWithDefaultConstructor(implClass);
        }
    }

    private <T> T createWithAutowiredConstructor(Constructor<T> constructor) {
        try {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] parameters = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                parameters[i] = context.getObject(parameterTypes[i]);
            }

            return constructor.newInstance(parameters);
        } catch (Exception e) {
            throw new ObjectInstantiationException("Failed to create bean using autowired constructor", e);
        }
    }

    private <T> T createWithDefaultConstructor(Class<T> implClass) {
        try {
            return implClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new ObjectInstantiationException("Failed to create bean using default constructor", e);
        }
    }

    private <T> void invokeInit(Class<T> implClass, T t) {
        for (Method method : implClass.getMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                try {
                    method.invoke(t);
                } catch (Exception e) {
                    throw new ObjectInstantiationException("Failed to invoke @PostConstruct method", e);
                }
            }
        }
    }
}
