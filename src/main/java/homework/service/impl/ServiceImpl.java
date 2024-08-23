package homework.service.impl;

import homework.annotations.Autowired;
import homework.annotations.Component;
import homework.repository.DBInterface;
import homework.service.ServiceInterface;

@Component
public class ServiceImpl implements ServiceInterface {
    private final DBInterface databaseInterface;

    @Autowired
    public ServiceImpl(DBInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }

    @Override
    public String execute() {
        return databaseInterface.execute();
    }
}
