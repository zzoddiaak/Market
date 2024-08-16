package homework.entity;

import homework.annotations.Component;
import homework.annotations.Value;
import lombok.Getter;

@Component
public class ParameterHolder {
    @Getter
    @Value("parameters.holder.text")
    private String someText;
}
