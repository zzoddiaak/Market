package homework.config;

import homework.context.ApplicationContext;

public interface ObjectConfig {
    void configure(Object t, ApplicationContext context);
}