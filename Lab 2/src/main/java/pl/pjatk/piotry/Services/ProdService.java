package pl.pjatk.piotry.Services;

import org.springframework.stereotype.Service;
import pl.pjatk.piotry.Interfaces.HandlerServiceInterface;

@Service("prodService")
public class ProdService implements HandlerServiceInterface {

    @Override
    public String handleRequest() {
        return "Hello from ProdService";
    }
}
