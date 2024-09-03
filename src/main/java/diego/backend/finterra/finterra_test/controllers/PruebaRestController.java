package diego.backend.finterra.finterra_test.controllers;

import org.springframework.web.bind.annotation.RestController;

import diego.backend.finterra.finterra_test.controllers.abstracts.ResponseApi;
import diego.backend.finterra.finterra_test.dtos.ResponseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("prueba")
public class PruebaRestController extends ResponseApi {

  @SecurityRequirement(name = "basicAuth")
  @GetMapping("no-authorized")
  public ResponseEntity<ResponseDto> noAuthorized() {
    ResponseDto respose = new ResponseDto();
    respose.setMessage("no-authorized HOLA MUNDO");
    return returnResponse(respose);
  }

  @GetMapping("authorized")
  public ResponseEntity<ResponseDto> authorized() {

    ResponseDto respose = new ResponseDto();
    respose.setMessage("Authorized HOLA MUNDO");
    return returnResponse(respose);
  }
}
