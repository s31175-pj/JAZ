package pl.pjatk.piotry.Services;

import org.springframework.stereotype.Service;
import pl.pjatk.piotry.Interfaces.HandlerServiceInterface;

@Service("devService")
public class DevService implements HandlerServiceInterface {
    @Override
    public String handleRequest()
    {
        return "Hello from DevService";
    }
}
