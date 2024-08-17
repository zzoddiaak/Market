package homework;

import homework.config.impl.JavaConfig;
import homework.context.ApplicationContext;
import homework.factory.ObjectFactory;

public class Application {
    public static ApplicationContext run(String packageToScan) {
        JavaConfig config = new JavaConfig(packageToScan);
        ApplicationContext context = ApplicationContext.getInstance(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setFactory(objectFactory);
        return context;
    }
}