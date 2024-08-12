package homework.annotations.impl;

import homework.annotations.Value;
import homework.config.ObjectConfig;
import homework.config.impl.PropertyManager;
import homework.context.ApplicationContext;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class ValueObjectConfigurator implements ObjectConfig {
    private final PropertyManager propertyManager = PropertyManager.getInstance();

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            Value annotation = field.getAnnotation(Value.class);

            if (annotation != null) {
                String value = annotation.value().isEmpty() ? propertyManager.getProperty(field.getName()) : propertyManager.getProperty(annotation.value());
                field.setAccessible(true);
                field.set(t, value);
            }
        }
    }
}
