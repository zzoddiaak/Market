package homework.config.impl;

import homework.config.Config;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {
    private Reflections scanner;
    private Map<Class<?>, Class<?>> ifc2ImplClass = new HashMap<>();

    public JavaConfig(String packageToScan, Map<Class<?>, Class<?>> ifc2ImplClass) {
        this.ifc2ImplClass = ifc2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> type) {
        if (type.isInterface()) {
            if (ifc2ImplClass.containsKey(type)) {
                return (Class<? extends T>) ifc2ImplClass.get(type);
            }

            Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
            if (classes.size() != 1) {
                throw new RuntimeException(type + " has 0 or more than one implementation. Please update your config.");
            }

            Class<? extends T> implClass = classes.iterator().next();
            ifc2ImplClass.put(type, implClass);
            return implClass;
        } else {
            return type;
        }
    }

    @Override
    public Reflections getScanner() {
        return scanner;
    }
}
