package homework;

import homework.controller.UserCredentialController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("homework");
        UserCredentialController userCredentialController = context.getBean(UserCredentialController.class);

        userCredentialController.deleteById(1L);
        userCredentialController.update(2, """
                {
                    "password":"45646",
                    "username":"anton"
                }
                """);

        System.out.println("User Credentials: \n" + userCredentialController.findAll());
    }
}
