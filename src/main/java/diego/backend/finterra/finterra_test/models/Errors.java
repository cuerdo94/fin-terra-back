package diego.backend.finterra.finterra_test.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Errors {
  private List<Map<String, String>> errors = new ArrayList<>();

  public List<Map<String, String>> getErrors() {
    return errors;
  }

  public void add(String key, String value) {
    errors.add(Map.of(key, value));

  }
}
