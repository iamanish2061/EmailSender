package com.EmailSender.controller;

import com.EmailSender.entity.EmailSender;
import com.EmailSender.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderController {

    @Autowired
    private EmailSenderService emailSenderService;

    // you can hit this endpoint via postman
    // method : POST
    // URL : localhost:8080/send-mail
    //Body->
        // select raw and choose json
        //{
        //    "to" : "anishnitro5@gmail.com",
        //    "subject" : "Testing if Email Sender service works",
        //    "body" : "Hello I am Anish Shrestha. I am sending this mail via springboot application."
        //}
    @PostMapping("/send-mail")
    public String sendMail(@RequestBody EmailSender emailSender){
        return emailSenderService.sendEmail(emailSender);
    }

}
