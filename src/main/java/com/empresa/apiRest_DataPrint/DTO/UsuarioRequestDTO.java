package com.empresa.apiRest_DataPrint.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioRequestDTO {
    private String correo;
    private String clave;
}
