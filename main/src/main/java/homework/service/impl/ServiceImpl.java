package homework.service.impl;

import homework.annotations.Autowired;
import homework.annotations.Component;
import homework.repository.DBInterface;
import homework.service.ServiceInterface;


@Component
public class ServiceImpl implements ServiceInterface {
    private DBInterface databaseInterface;

    @Autowired
    public void setDatabaseInterface(DBInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }

    @Override
    public String execute() {
        return databaseInterface.execute();
    }
}
