package pl.pjatk.piotry.Services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RequestExecutor {

    @Value("${app.environment:dev}")
    private String environment;

    FacadeService facadeService;


    public RequestExecutor(FacadeService facadeService)
    {
        this.facadeService = facadeService;


    }

    @PostConstruct
    public void init()
    {
        System.out.println(facadeService.execute(environment));
    }
}
