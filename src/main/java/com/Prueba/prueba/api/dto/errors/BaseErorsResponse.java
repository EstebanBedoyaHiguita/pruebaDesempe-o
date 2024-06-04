package com.Prueba.prueba.api.dto.errors;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseErorsResponse  implements Serializable {
    private String status;
    private Integer code;
}
