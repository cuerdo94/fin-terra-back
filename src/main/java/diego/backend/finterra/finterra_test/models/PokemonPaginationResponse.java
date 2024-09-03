package diego.backend.finterra.finterra_test.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonPaginationResponse {

  private String name;
  @JsonProperty("pokemon_species")
  private List<PokemonDetailPaginationResponse> pokemonSpecies;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  static public class PokemonDetailPaginationResponse {
    private String name;
    private String url;
  }
}
