package com.terzeron.grammar.mail;

public class SendMailTest {
    public static void main(String[] args) {
        String from = "terzeron@gmail.com";
        String to = "terzeron@gmail.com";
        String subject = "Test";
        String message = "A grammar message";

        SendMail sendMail = new SendMail(from, to, subject, message);
        sendMail.send();
    }
}
