package diego.backend.finterra.finterra_test.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

  private Integer code;
  private String message;
  private Object body;

  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  private final Map<Integer, String> mapErrors = Map.ofEntries(
      Map.entry(200, "Operación exitosa"),
      Map.entry(201, "Creación exitosa"),
      Map.entry(202, "Solicitud aceptada, procesándose"),
      Map.entry(204, "Sin contenido"),
      Map.entry(400, "Solicitud incorrecta, verifique los parámetros"),
      Map.entry(401, "No autorizado, se requiere autenticación valida"),
      Map.entry(403, "Prohibido, no tiene permisos para acceder"),
      Map.entry(404, "No se encuentra el recurso solicitado"),
      Map.entry(405, "Método no permitido"),
      Map.entry(409, "Conflicto, la solicitud no se puede completar"),
      Map.entry(500, "Error interno del servidor"),
      Map.entry(502, "Puerta de enlace incorrecta"),
      Map.entry(503, "Servicio no disponible, intente más tarde"),
      Map.entry(504, "Tiempo de espera agotado en la puerta de enlace"));

  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  private final SimpleDateFormat formatoFechaHumana = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  public String getDate() {
    return formatoFechaHumana.format(new Date());
  }

  public String getMessage() {
    return message != null ? message : mapErrors.getOrDefault(getCode(), "Mensaje no definido");
  }

  public Integer getCode() {
    return code == null ? HttpStatus.OK.value() : code;
  }

}
