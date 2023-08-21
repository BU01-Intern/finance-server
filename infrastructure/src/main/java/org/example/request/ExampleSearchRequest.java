package org.example.request;

import lombok.Data;
import org.example.dto.PageRequest;

@Data
public class ExampleSearchRequest extends PageRequest {
    private String name;

}
