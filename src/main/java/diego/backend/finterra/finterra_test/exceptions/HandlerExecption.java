package diego.backend.finterra.finterra_test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;

import diego.backend.finterra.finterra_test.controllers.abstracts.ResponseApi;
import diego.backend.finterra.finterra_test.dtos.ResponseDto;
import diego.backend.finterra.finterra_test.exceptions.customs.CustomException;

import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class HandlerExecption extends ResponseApi {

  @ExceptionHandler({ NoHandlerFoundException.class })
  public ResponseEntity<ResponseDto> notFound(NoHandlerFoundException ex) {
    ResponseDto error = new ResponseDto();
    error.setCode(HttpStatus.NOT_FOUND.value());
    error.setMessage(ex.getMessage());
    return this.returnResponse(error);
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<ResponseDto> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
    ResponseDto error = new ResponseDto();
    error.setCode(HttpStatus.FORBIDDEN.value());
    error.setMessage(ex.getMessage());
    return this.returnResponse(error);
  }

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<ResponseDto> handleResponseStatusException(ResponseStatusException ex) {
    ResponseDto error = new ResponseDto();
    error.setCode(ex.getStatusCode().value());
    error.setMessage(ex.getMessage());
    return this.returnResponse(error);
  }

  @ExceptionHandler({ CustomException.class })
  public ResponseEntity<ResponseDto> notFound(CustomException ex) {
    return this.returnResponse(ex.getErrors());
  }

}
