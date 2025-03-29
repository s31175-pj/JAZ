package pl.pjatk.piotry.Services;

import org.springframework.stereotype.Service;
import pl.pjatk.piotry.Interfaces.HandlerServiceInterface;

@Service("stagingService")
public class StagingService implements HandlerServiceInterface
{

    @Override
    public String handleRequest() {
        return "Hello from StagingService";
    }
}
