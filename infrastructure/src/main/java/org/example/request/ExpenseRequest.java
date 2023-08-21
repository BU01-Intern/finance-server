package org.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseRequest {

    private Integer id;
    private String name;
    @JsonProperty("account_number")
    private Long accountNumber;
    private String type;
    @JsonProperty("is_distributed")
    private Boolean isDistributed;
    private Integer status;
}
