package homework.config.impl;

import homework.config.Config;
import lombok.Getter;
import org.reflections.Reflections;
import java.util.Set;

public class JavaConfig implements Config {
    @Getter
    private Reflections scanner;

    public JavaConfig(String packageToScan) {
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        if (ifc.isInterface()) {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException(ifc + " has 0 or more than one impl, please update your config");
            }
            return classes.iterator().next();
        } else {
            return ifc;
        }
    }
}