
package diego.backend.finterra.finterra_test.controllers.abstracts;

import org.springframework.http.ResponseEntity;

import diego.backend.finterra.finterra_test.dtos.ResponseDto;

public abstract class ResponseApi {
  public ResponseEntity<ResponseDto> returnResponse(ResponseDto response) {
    return ResponseEntity.status(response.getCode()).body(response);
  }
}
