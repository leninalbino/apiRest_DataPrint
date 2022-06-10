package com.empresa.apiRest_DataPrint.model;

public class LoginUsuario {
    private String correo;
    private String clave;

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
