package diego.backend.finterra.finterra_test.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDto {
  private Long id;
  private String name;
  private String frontShinyImage;
  private double weight;
  private double height;
  private int attack;
  private int defense;
  private List<MoveDto> topMoves = new ArrayList<>();

}