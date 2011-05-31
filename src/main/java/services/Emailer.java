package services;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Mary Anne
 * Date: 5/27/11
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Emailer {

Properties props;

    public Emailer(){
        props= new Properties();
        // Nombre del host de correo, es smtp.gmail.com
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        // TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");
        // Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port","587");
        // Nombre del usuario
        props.setProperty("mail.smtp.user", "marycraig90@gmail.com");
        // Si requiere o no usuario y password para conectarse.
        props.setProperty("mail.smtp.auth", "true");

    }


    public void sendMail(String recipient, String subject, String text){
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("marycraig90@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(text);
           Transport t = session.getTransport("smtp");
            t.connect("coffeebreakapp@gmail.com","coffeebreak4$");
            t.sendMessage(message,message.getAllRecipients());
            t.close();
        } catch (MessagingException e) {

            e.printStackTrace();
        }
    }
}
