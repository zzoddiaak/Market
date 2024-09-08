package homework;

import homework.controller.BookingsController;
import homework.entity.Bookings;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =new AnnotationConfigApplicationContext("homework");



        Runnable sessionTask = () -> {
            BookingsController bookingsController = context.getBean(BookingsController.class);
            bookingsController.deleteById(1L);
            bookingsController.update(2, """
                {
                        
                      "start_date" : "2024-04-17T08:35:00",
                      "end_date" : "2024-05-12T09:30:00"
                }
                """);
            System.out.println("Session: \n" + bookingsController.findAll());

        };
        sessionTask.run();


    }
}
