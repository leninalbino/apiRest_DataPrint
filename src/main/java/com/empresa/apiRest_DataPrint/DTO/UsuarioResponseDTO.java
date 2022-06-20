package com.empresa.apiRest_DataPrint.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioResponseDTO {
    private String token ;

    public UsuarioResponseDTO(String token) {
        this.token = token;
    }


}
