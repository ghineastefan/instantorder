package com.softdight.instantorder.backend.helper;

import com.itextpdf.text.DocumentException;
import com.softdight.instantorder.backend.model.Menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MailManager {

    public void sendMenuViaEmail(String to, Menu menu, String template) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

        // Sender's email ID needs to be mentioned
        String from = "softdight@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        String key = "Bar12345Bar22345"; // 128 bit key
        // Create key and cipher
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        byte[] encrypted = new byte[]{-108, -128, 17, -7, -12, -2, -33, -23, -120, 39, -71, 11, 105, 97, -88, 12};
        // decrypt the text
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decrypted = new String(cipher.doFinal(encrypted));

        // Get the Session object.// and pass
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, decrypted);
            }
        });
        //session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            Multipart multipart = new MimeMultipart();

            MimeBodyPart attachmentPart = new MimeBodyPart();

            MimeBodyPart textPart = new MimeBodyPart();

            try {
                // write the html down
                String str = MenuTemplates.buildTemplateOne(menu);
                final String filename =  menu.getName() + "_" + template + ".html";
                BufferedWriter writer = new BufferedWriter(new FileWriter("backend\\src\\main\\resources\\template\\"+filename));
                writer.write(str);
                writer.close();
                MenuTemplates.generatePDFFromHTML("backend\\src\\main\\resources\\template\\"+filename);
                File f = new File("backend\\src\\main\\resources\\template\\" + filename + ".pdf");

                attachmentPart.attachFile(f);
                textPart.setText("This is text");
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);

            } catch (IOException | DocumentException e) {

                e.printStackTrace();
            }

            message.setContent(multipart);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
