package org.example.request;

import org.example.dto.PageRequest;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ExpenseSearchRequest extends PageRequest {

    private String name = "";
    private String accountNumber = "";
}
