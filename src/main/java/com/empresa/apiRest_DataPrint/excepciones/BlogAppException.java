package com.empresa.apiRest_DataPrint.excepciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@Getter
@Setter
@AllArgsConstructor
public class BlogAppException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private HttpStatus estado;
    private String mensaje;
}
