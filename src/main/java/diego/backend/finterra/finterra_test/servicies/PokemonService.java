package diego.backend.finterra.finterra_test.servicies;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diego.backend.finterra.finterra_test.dtos.MoveDto;
import diego.backend.finterra.finterra_test.dtos.PokemonDto;
import diego.backend.finterra.finterra_test.models.MoveResponse;
import diego.backend.finterra.finterra_test.models.PaginatedResponse;
import diego.backend.finterra.finterra_test.models.PokemonPaginationResponse;
import diego.backend.finterra.finterra_test.models.PokemonResponse;
import diego.backend.finterra.finterra_test.models.PokemonResponse.MoveWrapper;
import diego.backend.finterra.finterra_test.repositories.PokemonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokemonService {

  @Autowired
  PokemonRepository pokemonRepository;

  public PokemonDto getNameOrId(String nameOrId) {

    Mono<PokemonResponse> data = pokemonRepository.getNameOrId(nameOrId);

    PokemonDto pokemonDto = new PokemonDto();
    pokemonDto.setId(data.block().getId());
    pokemonDto.setName(data.block().getName());
    pokemonDto.setWeight(data.block().getWeight());
    pokemonDto.setHeight(data.block().getHeight());
    pokemonDto.setFrontShinyImage(data.block().getSprites().getFrontShiny());
    pokemonDto.setAttack(data.block().getStats().stream().filter(stat -> "attack".equals(stat.getStat().getName()))
        .map(PokemonResponse.StatWrapper::getBaseStat)
        .findFirst().get());

    pokemonDto.setDefense(data.block().getStats().stream().filter(stat -> "defense".equals(stat.getStat().getName()))
        .map(PokemonResponse.StatWrapper::getBaseStat)
        .findFirst().get());

    List<Mono<MoveResponse>> list = data.block().getMoves().stream()
        .map((MoveWrapper move) -> pokemonRepository.getMovePower(move.getMove().getName()))
        .collect(Collectors.toList());

    List<MoveDto> topThreeMoves = Flux.fromIterable(list)
        .flatMap(mono -> mono)
        .map(moveResponse -> {
          MoveDto moveDto = new MoveDto();
          moveDto.setName(moveResponse.getName());
          moveDto.setPower(moveResponse.getPower());
          return moveDto;
        })
        .sort(Comparator.comparingInt(MoveDto::getPower).reversed())
        .take(3)
        .collectList()
        .block();

    pokemonDto.setTopMoves(topThreeMoves);

    return pokemonDto;
  }

  public MoveDto getMovePower(String nameOrId) {
    MoveResponse data = pokemonRepository.getMovePower(nameOrId).block();
    MoveDto moveDto = new MoveDto();
    moveDto.setName(data.getName());
    moveDto.setPower(data.getPower());
    return moveDto;
  }

  public PaginatedResponse<PokemonPaginationResponse.PokemonDetailPaginationResponse> getPokemonsByGeneration(
      int generation, int page, int limit) {

    PokemonPaginationResponse data = pokemonRepository.getPokemonsByGeneration(generation).block();
    int currentPage = (page <= 1 ? 1 : page);
    int offset = limit * (currentPage - 1);
    int totalElements = data.getPokemonSpecies().size();
    int totalPages = (int) Math.ceil((double) totalElements / limit);

    List<PokemonPaginationResponse.PokemonDetailPaginationResponse> paginatedList = data.getPokemonSpecies().stream()
        .skip(offset)
        .limit(limit)
        .collect(Collectors.toList());

    PaginatedResponse<PokemonPaginationResponse.PokemonDetailPaginationResponse> paginatedResponse = new PaginatedResponse<>();
    paginatedResponse.setContent(paginatedList);
    paginatedResponse.setTotalElements(totalElements);
    paginatedResponse.setTotalPages(totalPages);
    paginatedResponse.setCurrentPage(currentPage);
    paginatedResponse.setPageSize(limit);
    paginatedResponse.setCurrentTotal(paginatedList.size());

    return paginatedResponse;

  }

}
