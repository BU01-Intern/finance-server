package org.example.request;

import org.example.dto.PageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExpenseSearchRequest extends PageRequest {

    private String name = "";
    @JsonProperty("account_number")
    private String accountNumber = "";
}
