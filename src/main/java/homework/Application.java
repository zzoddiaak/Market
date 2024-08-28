package homework;

import homework.controller.BookingsController;
import homework.controller.UserController;
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

        UserController userController = context.getBean(UserController.class);
        userController.deleteById(1L);
        userController.update(2,"""
                {
                    "firstName":"Anton",
                    "lastname":"Antonio"
                    "bio":"Top"
                }""");
        System.out.println("User: \n" + userController.findAll());


        BookingsController bookingsController = context.getBean(BookingsController.class);
        bookingsController.deleteById(1L);
        bookingsController.update(2, """
                {
                    "status":"Lua"
                }""");
        System.out.println("Bookings: \n" + bookingsController.findAll());
    }
}
