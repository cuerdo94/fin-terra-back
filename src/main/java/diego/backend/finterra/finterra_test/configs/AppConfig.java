package diego.backend.finterra.finterra_test.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  WebClient.Builder webClientBuilder() {
    return WebClient.builder()
        .exchangeStrategies(ExchangeStrategies.builder()
            .codecs(configurer -> configurer.defaultCodecs()
                .maxInMemorySize(10 * 1024 * 1024))
            .build());
  }
}
