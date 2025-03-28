package pl.pjatk.piotry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.piotry.Services.FacadeService;
import pl.pjatk.piotry.Services.RequestExecutor;

@RestController
@RequestMapping("/endpoint")
public class AppController {

    FacadeService facadeService;

    public AppController(FacadeService facadeService)
    {
        this.facadeService = facadeService;
    }

    @GetMapping("/message")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok(facadeService.execute("prod"));
    }

}
