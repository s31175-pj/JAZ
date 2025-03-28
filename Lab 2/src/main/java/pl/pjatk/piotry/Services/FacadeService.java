package pl.pjatk.piotry.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.pjatk.piotry.Interfaces.HandlerServiceInterface;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacadeService {
    ProdService prodService;
    QaService qaService;
    DevService devService;

    private final Map<String, HandlerServiceInterface> handlers = new HashMap<>();

    @Autowired
    public FacadeService(@Qualifier("devService") HandlerServiceInterface devService,
                         @Qualifier("qaService") HandlerServiceInterface qaService,
                         @Qualifier("prodService") HandlerServiceInterface prodService) {
        handlers.put("dev", devService);
        handlers.put("qa", qaService);
        handlers.put("prod", prodService);
    }

    public FacadeService(ProdService prodService, QaService qaService, DevService devService)
    {
        this.prodService = prodService;
        this.qaService = qaService;
        this.devService = devService;
    }

    public String execute(String environment)
    {
        HandlerServiceInterface handler = handlers.get(environment);

//        return switch (environment) {
//            case "dev" -> devService.handleRequest();
//            case "qa" -> qaService.handleRequest();
//            case "prod" -> prodService.handleRequest();
//            case "staging" -> "Hello from Staging";
//            default -> null;
//        };

        return handler.handleRequest();
    }
}
