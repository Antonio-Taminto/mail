package com.mail;

public class Mail {
    private String to;
    private String subject;
    private String text;

    public Mail(String subject, String text, String to) {
        this.subject = subject;
        this.text = text;
        this.to = to;
    }

    public Mail() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
