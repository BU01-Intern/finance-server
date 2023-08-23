package org.example.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseRequest {

    private Integer id;
    private String name;
    private String accountNumber;
    private String type;
    private Boolean isDistributed;
    private Integer status;
}
