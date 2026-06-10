package model;

import service.EncryptionUtil;

public class Email {

    private String sender;
    private String subject;
    private String content; // stored ENCRYPTED
    private String category;
    private boolean important;

    public Email(String sender, String subject, String content) {
        this.sender = sender;
        this.subject = subject;

        // 🔒 encrypt content before storing
        this.content = EncryptionUtil.encrypt(content);

        this.category = "Uncategorized";
        this.important = false;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // 🔒 return decrypted content when needed
    public String getContent() {
        return EncryptionUtil.decrypt(content);
    }

    // optional raw encrypted value access
    public String getEncryptedContent() {
        return content;
    }

    // if you still want to update content
    public void setContent(String content) {
        this.content = EncryptionUtil.encrypt(content);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public void displayEmail() {

        System.out.println("\n----- EMAIL -----");
        System.out.println("Sender: " + sender);
        System.out.println("Subject: " + subject);

        // 🔓 decrypted output
        System.out.println("Content: " + getContent());

        System.out.println("Category: " + category);
        System.out.println("Important: " + important);
    }
}