package pl.pjatk.RentalService;// Example: src/main/java/pl/pjkat/rentalservice/config/SwaggerConfig.java
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig { // Ważne

    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info().title("Rental Service").version("1.0").description("Rental Service");
    }
}