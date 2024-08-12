package homework.annotations.impl;

import homework.annotations.Autowired;
import homework.config.ObjectConfig;
import homework.context.ApplicationContext;
import lombok.SneakyThrows;


import java.lang.reflect.Field;

public class AutowiredFieldObjectConfigurator implements ObjectConfig {
    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);

                Object object = context.getObject(field.getType());

                field.set(t, object);
            }
        }
    }
}