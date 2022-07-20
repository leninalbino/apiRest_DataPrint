package com.empresa.apiRest_DataPrint.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class PaymentIntentDTO {
    public enum  Currency {
        PEN;
    }
    private String description; // descripcion la lista de los productos a comprar
    private int amount; // precio
    private Currency currency; // tipo Moneda
}
