package diego.backend.finterra.finterra_test.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse {

  private Long id;
  private String name;
  private int weight;
  private int height;
  private Sprites sprites;
  private List<StatWrapper> stats;
  private List<MoveWrapper> moves;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Sprites {
    @JsonProperty("front_shiny")
    private String frontShiny;

  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class StatWrapper {
    @JsonProperty("base_stat")
    private int baseStat;
    private Stat stat;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Stat {
      private String name;

    }
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class MoveWrapper {
    private Move move;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Move {
      private String name;
      private String url;

    }
  }

}
