package org.example.request;

import org.example.dto.PageRequest;
import lombok.Data;

@Data
public class ExpenseSearchRequest extends PageRequest {

    private String name = "";
    private String accountNumber = "";
}
