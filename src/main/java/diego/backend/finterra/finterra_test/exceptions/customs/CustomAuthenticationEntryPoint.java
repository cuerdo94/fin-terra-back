package diego.backend.finterra.finterra_test.exceptions.customs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import diego.backend.finterra.finterra_test.dtos.ResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException {

    ResponseDto responseDto = new ResponseDto();
    responseDto.setCode(HttpStatus.UNAUTHORIZED.value());

    response.setContentType("application/json");
    response.setStatus(responseDto.getCode());

    String jsonResponse = objectMapper.writeValueAsString(responseDto);
    response.getWriter().write(jsonResponse);
  }
}