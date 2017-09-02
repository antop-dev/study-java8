package ch04.sec02;

import java.util.ArrayList;

public final class Message implements Cloneable {
    private String sender;
    private ArrayList<String> recipients;
    private String text;

    public Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
        recipients = new ArrayList<>();
    }

    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }

    @Override
    public Message clone() {
        Message cloned = new Message(sender, text);
        cloned.recipients = new ArrayList<>(recipients);
        return cloned;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }
}