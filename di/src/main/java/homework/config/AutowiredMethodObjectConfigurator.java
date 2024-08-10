package homework.config;

import homework.annotations.Autowired;
import homework.context.ApplicationContext;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class AutowiredMethodObjectConfigurator implements ObjectConfig {
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
