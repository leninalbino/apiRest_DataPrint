package com.empresa.apiRest_DataPrint.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class PaymentIntentDTO {
    public enum  Currency {
        USD, EURO, NUEVOSOl;
    }
    private String description; // descripcion
    private int amount; // precio
    private Currency currency; // tipo Moneda
}
