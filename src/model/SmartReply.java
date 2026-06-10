package model;

public class SmartReply extends Email {

    public SmartReply(String sender, String subject, String content) {
        super(sender, subject, content);
    }

    @Override
    public void displayEmail() {
        super.displayEmail();
        System.out.println("AI Features Enabled");
    }
}