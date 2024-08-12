package homework.repository.impl;

import homework.annotations.Autowired;
import homework.annotations.Component;
import homework.entity.ParameterHolder;
import homework.repository.DBInterface;

@Component
public class DBImpl implements DBInterface {
    @Autowired
    private ParameterHolder parametersHolder;

    @Override
    public String execute() {
        return parametersHolder.getSomeText();
    }
}
