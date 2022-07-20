package com.empresa.apiRest_DataPrint.service;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EnvioCorreoImpl implements EnvioCorreo{
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void verificacionCorreo(Usuarios usuarios) throws UnsupportedEncodingException, MessagingException {
        String subject = "Data Print";
        String token = usuarios.getTokenVerificacion();
        String body = "Sr.(a) " + usuarios.getNombre() + " Para poder acceder por completo a nuestras ofertas y productos "+
                        " Usted debe verificar su cuenta escribiendo este codigo en la aplicacion : "+ token;
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(usuarios.getCorreo());
        helper.setSubject(subject);
        helper.setText(body);
        javaMailSender.send(message);
    }
}
