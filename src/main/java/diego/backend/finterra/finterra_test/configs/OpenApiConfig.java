package diego.backend.finterra.finterra_test.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Consumo de Api pokemon", version = " 1.0.0", description = "Prueba técnica"))
public class OpenApiConfig {

}
