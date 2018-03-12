package net.terzeron.test.mail;

public class SendMailTest {
    public static void main(String[] args) {
        String from = "terzeron@gmail.com";
        String to = "terzeron@gmail.com";
        String subject = "Test";
        String message = "A test message";

        SendMail sendMail = new SendMail(from, to, subject, message);
        sendMail.send();
    }
}
