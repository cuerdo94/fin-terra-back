package diego.backend.finterra.finterra_test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponse<T> {
  private List<T> content;

  @JsonProperty("total_elements")
  private int totalElements;
  
  @JsonProperty("total_pages")
  private int totalPages;
  
  @JsonProperty("current_pages")
  private int currentPage;
  
  @JsonProperty("current_total")
  private int currentTotal;
  
  @JsonProperty("page_sizes")
  private int pageSize;
}
