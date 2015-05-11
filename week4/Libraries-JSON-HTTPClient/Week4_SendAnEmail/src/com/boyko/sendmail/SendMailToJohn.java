package com.boyko.sendmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendMailToJohn {
    public static void main(String[] args) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(null);
        email.setAuthenticator(new DefaultAuthenticator("boiskila", "........"));
        email.setSSLOnConnect(true);
        email.setDebug(true);
        email.setFrom("boiskila@gmail.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("boiskila@gmail.com");
        email.send();
    }
}
