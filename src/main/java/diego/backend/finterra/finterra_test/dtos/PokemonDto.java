package diego.backend.finterra.finterra_test.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDto {
  private Long id;
  private String name;
  @JsonProperty("front_shiny_image")
  private String frontShinyImage;
  private double weight;
  private double height;
  private int attack;
  private int defense;
  @JsonProperty("top_moves")
  private List<MoveDto> topMoves = new ArrayList<>();

}