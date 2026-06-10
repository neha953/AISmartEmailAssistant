package service;

public class ReplyGenerator implements AIService {

    @Override
    public String categorizeEmail(String content) {
        return "";
    }

    @Override
    public String generateReply(String content) {

        content = content.toLowerCase();

        if(content.contains("meeting"))
            return "Thank you. I will attend the meeting.";

        if(content.contains("assignment"))
            return "Thank you. I have received the assignment.";

        if(content.contains("invoice"))
            return "Thank you. I will review the invoice.";

        if(content.contains("offer"))
            return "Thank you for the offer.";

        return "Thank you for your email.";
    }
}