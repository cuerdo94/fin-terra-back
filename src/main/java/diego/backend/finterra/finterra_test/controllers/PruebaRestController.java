package diego.backend.finterra.finterra_test.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("prueba")
public class PruebaRestController {

  @GetMapping("no-authorized")
  public String noAuthorized() {
    return "HOLA MUNDO";
  }

  @GetMapping("authorized")
  public String authorized() {
    return "Authorized HOLA MUNDO";
  }
}
