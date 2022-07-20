package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Usuarios;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EnvioCorreo {

    void verificacionCorreo(Usuarios usuarios)throws UnsupportedEncodingException, MessagingException;
}
