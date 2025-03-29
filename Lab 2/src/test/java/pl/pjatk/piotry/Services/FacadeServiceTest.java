package pl.pjatk.piotry.Services;

import org.junit.jupiter.api.BeforeEach;
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
    HandlerServiceInterface prodService;

    @Mock
    HandlerServiceInterface qaService;

    @Mock
    HandlerServiceInterface devService;

    @Mock
    HandlerServiceInterface stagingService;

    private FacadeService facadeService;

    @BeforeEach
    public void setUp() {
        facadeService = new FacadeService(devService, qaService, prodService, stagingService);
    }

    @Test
    public void testExecuteDevEnvironment() {
        when(devService.handleRequest()).thenReturn("Hello from Dev");
        assertEquals("Hello from Dev", facadeService.execute("dev"));
    }

    @Test
    public void testExecuteQaEnvironment() {
        when(qaService.handleRequest()).thenReturn("Hello from QA");
        assertEquals("Hello from QA", facadeService.execute("qa"));
    }

    @Test
    public void testExecuteProdEnvironment() {
        when(prodService.handleRequest()).thenReturn("Hello from Prod");
        assertEquals("Hello from Prod", facadeService.execute("prod"));
    }

    @Test
    public void testExecuteStagingEnvironment() {
        when(stagingService.handleRequest()).thenReturn("Hello from Staging");
        assertEquals("Hello from Staging", facadeService.execute("staging"));
    }
}