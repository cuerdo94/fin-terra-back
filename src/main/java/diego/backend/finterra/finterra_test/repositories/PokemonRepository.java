package diego.backend.finterra.finterra_test.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import diego.backend.finterra.finterra_test.exceptions.customs.CustomException;
import diego.backend.finterra.finterra_test.models.MoveResponse;
import diego.backend.finterra.finterra_test.models.PokemonResponse;
import reactor.core.publisher.Mono;

@Repository
public class PokemonRepository {
  private final WebClient webClient;

  public PokemonRepository(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://pokeapi.co/api/v2").build();
  }

  public Mono<PokemonResponse> getNameOrId(String nameOrId) {
    return webClient.get()
        .uri("/pokemon/{nameOrId}", nameOrId)
        .retrieve()
        .bodyToMono(PokemonResponse.class).onErrorResume(WebClientResponseException.class, e -> {
          return Mono.error(new CustomException(404, "No se encontro " + nameOrId, null));
        });
  }

  public Mono<MoveResponse> getMovePower(String nameOrId) {
    return webClient.get()
        .uri("/move/{nameOrId}", nameOrId)
        .retrieve()
        .bodyToMono(MoveResponse.class).onErrorResume(WebClientResponseException.class, e -> {
          return Mono.error(new CustomException(404, "No se encontro " + nameOrId, null));
        });
  }
}
