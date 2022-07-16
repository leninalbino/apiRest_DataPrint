package com.empresa.apiRest_DataPrint.DTO;

import lombok.*;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class UsuarioRequestDTO {
    private String correo;
    private String clave;
}
