package org.example.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseRequest {

    @NotNull(groups = OnUpdate.class, message = "ID is required.")
    private Integer id;

    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @NotBlank(message = "Account number cannot be empty.")
    private String accountNumber;

    private String type = "";
    private Boolean isDistributed = false;
    private Integer status = 0;
}
