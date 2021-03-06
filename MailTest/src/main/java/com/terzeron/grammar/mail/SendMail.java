package com.terzeron.grammar.mail;

import lombok.extern.slf4j.Slf4j;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Slf4j
public class SendMail {
    private String from;
    private String to;
    private String subject;
    private String text;

    public SendMail(String from, String to, String subject, String text) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public void send() {
        Properties props = new Properties();
        props.put("com.terzeron.grammar.mail.smtp.host", "smtp.gmail.com");
        props.put("com.terzeron.grammar.mail.smtp.port", "587");
        Session mailSession = Session.getDefaultInstance(props);
        Message simpleMessage = new MimeMessage(mailSession);
        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;

        try {
            fromAddress = new InternetAddress(from);
            toAddress = new InternetAddress(to);
        } catch (AddressException e) {
            log.error(e.getMessage(), e);
        }

        try {
            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipient(MimeMessage.RecipientType.TO, toAddress);
            simpleMessage.setSubject(subject);
            simpleMessage.setText(text);
            Transport.send(simpleMessage);
        } catch (MessagingException e) {
            log.error(e.getMessage(), e);
        }
    }
}
