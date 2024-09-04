package homework.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class DataSourceProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;


}
