package diego.backend.finterra.finterra_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import diego.backend.finterra.finterra_test.controllers.abstracts.ResponseApi;
import diego.backend.finterra.finterra_test.dtos.ResponseDto;
import diego.backend.finterra.finterra_test.servicies.PokemonService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pokemon")
@RestController
@RequestMapping("pokemons")
public class PokemonRestController extends ResponseApi {
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{nameOrId}")
    public ResponseEntity<ResponseDto> getPokemon(@PathVariable String nameOrId) {

        ResponseDto respose = new ResponseDto();
        respose.setBody(pokemonService.getNameOrId(nameOrId));
        return returnResponse(respose);
    }

    @GetMapping("/move-power/{nameOrId}")
    public ResponseEntity<ResponseDto> getMovePower(@PathVariable String nameOrId) {

        ResponseDto respose = new ResponseDto();
        respose.setBody(pokemonService.getMovePower(nameOrId));
        return returnResponse(respose);

    }

    @GetMapping("/by-generation/{generation}")
    public ResponseEntity<ResponseDto> getPokemonsByGeneration(@PathVariable int generation,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit) {

        ResponseDto respose = new ResponseDto();
        respose.setBody(pokemonService.getPokemonsByGeneration(generation, page, limit));
        return returnResponse(respose);
    }
}
