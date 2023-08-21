package org.example.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ExpenseRequest {

    private Integer id;
    private String name;
    private Long accountNumber;
    private String type;
    private Boolean isDistributed;
    private Integer status;
}
