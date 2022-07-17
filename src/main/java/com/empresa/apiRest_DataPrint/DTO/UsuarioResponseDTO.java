package com.empresa.apiRest_DataPrint.DTO;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import lombok.*;

import java.util.List;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class UsuarioResponseDTO {
    //private String email;
    private String tokenDeAcceso;
   // private String tipoDeToken = "Bearer";


}
