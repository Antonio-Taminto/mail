package com.mail.DTO;

public class EmailRequest {
    private String to;
    private String subject;
    private String text;

    public EmailRequest(String subject, String text, String to) {
        this.subject = subject;
        this.text = text;
        this.to = to;
    }

    public EmailRequest() {
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
