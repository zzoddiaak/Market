package homework;

import homework.config.impl.JavaConfig;
import homework.context.ApplicationContext;
import homework.factory.ObjectFactory;
import java.util.HashMap;


public class Application {
    public static ApplicationContext run(String packageToScan){
        JavaConfig config = new JavaConfig(packageToScan, new HashMap<>());
        ApplicationContext context = ApplicationContext.getInstance(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setFactory(objectFactory);
        return  context;
    }
}