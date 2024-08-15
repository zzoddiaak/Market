package homework;

import homework.context.ApplicationContext;
import homework.controller.Controller;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("homework");

        Controller controller = context.getObject(Controller.class);
        controller.execute();
    }
}