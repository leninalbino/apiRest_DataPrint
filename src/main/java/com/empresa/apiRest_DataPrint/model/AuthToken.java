package com.empresa.apiRest_DataPrint.model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthToken {
    private String token;
    private  String user;
    private String correo;
    //private Long idUsuario;


   }
