package org.example.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseRequest {

    private Integer id;

    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @NotBlank(message = "Account number cannot be empty.")
    private String accountNumber;

    private String type;
    private Boolean isDistributed;
    private Integer status;
}
