package diego.backend.finterra.finterra_test.exceptions.customs;

import diego.backend.finterra.finterra_test.dtos.ResponseDto;
import diego.backend.finterra.finterra_test.models.Errors;

public class CustomException extends RuntimeException {
  private final ResponseDto data = new ResponseDto();

  public CustomException(Integer code, String message, Object body) {

    if (body instanceof Errors) {
      Errors errors = (Errors) body;
      this.data.setBody(errors.getErrors());
    } else {
      this.data.setBody(body);
    }
    this.data.setCode(code);
    this.data.setMessage(message);
  }

  public ResponseDto getErrors() {
    return data;
  }
}
