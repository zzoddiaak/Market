package homework.context;

import homework.annotations.Component;
import homework.config.Config;
import homework.factory.ObjectFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    private static ApplicationContext context;
    @Setter
    private ObjectFactory factory;

    private Map<Class, Object> cache = new ConcurrentHashMap<>();
    @Getter
    private Config config;
    private ApplicationContext(Config config){
        this.config = config;
    }

    public static ApplicationContext getInstance(Config config){
        if(context == null) {
            context = new ApplicationContext(config);
            return context;
        } else {
            return context;
        }
    }
    public <T> T getObject(Class<T> type){
        if (cache.containsKey(type)){
            return (T) cache.get(type);
        }

        Class<? extends T> implClass = type;

        if (type.isInterface()){
            implClass = config.getImplClass(type);
        }

        if (implClass.isAnnotationPresent(Component.class)){
            T t = factory.createObject(implClass);
            cache.put(type, t);
            return t;
        } else {
            return null;
        }
    }
}
