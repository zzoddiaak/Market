package homework.controller;

import homework.annotations.Autowired;
import homework.annotations.Component;
import homework.service.ServiceInterface;

@Component
public class Controller {
    private ServiceInterface serviceInterface;

    @Autowired
    public Controller(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public void execute() {
        System.out.println(serviceInterface.execute());
    }
}
