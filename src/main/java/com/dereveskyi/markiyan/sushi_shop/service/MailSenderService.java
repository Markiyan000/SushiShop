package com.dereveskyi.markiyan.sushi_shop.service;

import com.dereveskyi.markiyan.sushi_shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

@Service
public class MailSenderService {

    @Autowired
    CartItemService cartItemService;

    public void send(User user) {
        try {
            String text = "Dear " + user.getName() + " " + user.getSurname() + ", your order will be delivered in " +
                    new Random().nextInt(60) + " minutes!\nTo pay: " + cartItemService.getTotalSum() + " $\nThank you!";
            final String username = "sushishop278@gmail.com";
            final String password = "sushishop0980529814";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            javax.mail.Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject("Sushi Shop");
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
