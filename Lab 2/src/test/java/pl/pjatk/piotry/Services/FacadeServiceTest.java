package pl.pjatk.piotry.Services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import pl.pjatk.piotry.Interfaces.HandlerServiceInterface;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FacadeServiceTest {


    @Mock
    ProdService prodService;

    @Mock
    QaService qaService;

    @Mock
    DevService devService;

    @Mock
    HandlerServiceInterface handlerService;

    @InjectMocks
    FacadeService facadeService;

    @Test
    void execute() {
        when(facadeService.execute(any())).thenReturn("Hello from "+any());

        facadeService.execute("dev");
        facadeService.execute("prod");
        facadeService.execute("qa");

    }
}