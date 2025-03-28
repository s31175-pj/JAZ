package pl.pjatk.piotry.Services;

import org.springframework.stereotype.Service;
import pl.pjatk.piotry.Interfaces.HandlerServiceInterface;

@Service("qaService")
public class QaService implements HandlerServiceInterface {

    @Override
    public String handleRequest() {
        return "Hello from QaService";
    }
}
