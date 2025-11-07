package com.EmailSender.service;

import com.EmailSender.entity.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    private static final Logger log = LoggerFactory.getLogger(EmailSenderService.class);
    @Autowired
    private JavaMailSender javaMailSender;
    //JavaMailSender is the class that we use to send mails

    public String sendEmail(EmailSender emailSender) {
        try{
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(emailSender.getTo());
            mail.setSubject(emailSender.getSubject());
            mail.setText(emailSender.getBody());
            javaMailSender.send(mail);
            return "Email sent successfully!";
        }catch (Exception e){
            log.error("Exception while sending mail! :{}", e.getMessage());
            return "Failed to send mail! Please try again later";
        }

    }
}
