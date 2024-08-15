package homework.annotations.impl;

import homework.annotations.Autowired;
import homework.config.ObjectConfig;
import homework.context.ApplicationContext;
import lombok.SneakyThrows;


import java.lang.reflect.Field;

public class AutowiredFieldObjectConfigurator implements ObjectConfig {
    @Override
    public void configure(Object t, ApplicationContext context) {
        try {
            for (Field field : t.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);

                    Object object = context.getObject(field.getType());
                    if (object == null) {
                        throw new RuntimeException("No bean found for type: " + field.getType());
                    }

                    field.set(t, object);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to inject dependencies", e);
        }
    }

}