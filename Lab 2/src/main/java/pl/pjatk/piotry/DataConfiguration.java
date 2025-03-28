package pl.pjatk.piotry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pjatk.piotry.Components.ZwyklePojo;

@Configuration
@ConfigurationProperties(prefix="custom")
public class DataConfiguration {

    private String loginUrl;
    private String user;
    private String password;


    @Value("${my.custom.property:nieprawda}")
    String property;

    @Value("${my.custom.value}")
    Boolean init;

    @Bean
    public Object initBean()
    {
        if(init) return new Object();
        else return null;
    }


    @Bean
    public ZwyklePojo pojo()
    {
        System.out.println(property);
        return new ZwyklePojo();
    }

    @Bean
    public String[] defaultData()
    {
        String[] data = new String[5];
        data[0] = "Hello World";
        data[1] = "Hello 2";
        data[2] = "Hello 3";
        data[3] = "Hello 4";
        data[4] = "Hello 5";
        return new String[5];
    }
}
