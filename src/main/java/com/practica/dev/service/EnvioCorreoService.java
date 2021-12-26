package com.practica.dev.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.practica.dev.model.EnviarCorreoElectronico;

@Service
public class EnvioCorreoService {

	
	   //Importante hacer la inyección de dependencia de JavaMailSender:
    @Autowired
    private JavaMailSender mailSender;

    //Pasamos por parametro: destinatario, asunto y el mensaje
    public void sendEmail(String to, String subject, String content) {

    	String datosCorreo =  new EnviarCorreoElectronico().obtenerCorreo();  
    			
    			
   	 // Replace FROM with your "From" address.
        // This address must be added to Approved Senders in the console.
        final String FROM = "abeltrece@gmail.com";
        final String FROMNAME = to;
     
        // Replace TO with a recipient address.
        final String TO = to;
     
        // Replace smtp_username with your Oracle Cloud Infrastructure SMTP username generated in console.
        final String SMTP_USERNAME = FROM;
     
        // Replace smtp_password with your Oracle Cloud Infrastructure SMTP password generated in console.
        final String SMTP_PASSWORD = "oskqoecfsllzehvc";
     
        // Oracle Cloud Infrastructure Email Delivery hostname.
        final String HOST = "smtp.gmail.com";
     
        // The port you will connect to on the SMTP endpoint. Port 25 or 587 is allowed.
        final int PORT = 587;
     
           final String SUBJECT = FROM;
           final String BODY = String.join(
     
               System.getProperty("line.separator"),datosCorreo
           );
     
            // Create a Properties object to contain connection configuration information.
     
           Properties props = System.getProperties();
           props.put("mail.transport.protocol", "smtp");
           props.put("mail.smtp.port", PORT);
     
           //props.put("mail.smtp.ssl.enable", "true"); //the default value is false if not set
           props.put("mail.smtp.auth", "true");
           props.put("mail.smtp.auth.login.disable", "true");  //the default authorization order is "LOGIN PLAIN DIGEST-MD5 NTLM". 'LOGIN' must be disabled since Email Delivery authorizes as 'PLAIN'
           props.put("mail.smtp.starttls.enable", "true");   //TLSv1.2 is required
           props.put("mail.smtp.starttls.required", "true");  //Oracle Cloud Infrastructure required
     
            // Create a Session object to represent a mail session with the specified properties.
           Session session = Session.getDefaultInstance(props);
     
            // Create a message with the specified information.
            MimeMessage msg = new MimeMessage(session);
            try {
				msg.setFrom(new InternetAddress(FROM,FROMNAME));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				msg.setSubject(SUBJECT);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				msg.setContent(BODY,"text/html; charset=UTF-8");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     
            // Create a transport.
            Transport transport = null;
			try {
				transport = session.getTransport();
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
               
     
            // Send the message.
     
            try
            {
     
                System.out.println("Sending Email now...standby...");
     
     
                // Connect to OCI Email Delivery using the SMTP credentials specified.
                transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);    
     
                // Send email.
                transport.sendMessage(msg, msg.getAllRecipients());
                System.out.println("Email sent!");
     
            }
     
            catch (Exception ex) {
     
                System.out.println("The email was not sent.");
                System.out.println("Error message: " + ex.getMessage());
     
            }
     
            finally
     
            {
     
                // Close & terminate the connection.
                try {
					transport.close();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     
            }
     
        }
    
}
