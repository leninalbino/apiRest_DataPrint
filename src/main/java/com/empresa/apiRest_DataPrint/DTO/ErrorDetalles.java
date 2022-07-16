package com.empresa.apiRest_DataPrint.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class ErrorDetalles {
    private Date marcaDeTiempo;
    private String mensaje;
    private String detalles;
}
