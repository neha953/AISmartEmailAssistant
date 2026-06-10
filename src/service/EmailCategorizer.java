package service;

public class EmailCategorizer implements AIService {

    @Override
    public String categorizeEmail(String content) {

        content = content.toLowerCase();

        if(content.contains("meeting"))
            return "Work";

        if(content.contains("assignment"))
            return "Education";

        if(content.contains("invoice"))
            return "Finance";

        if(content.contains("offer"))
            return "Promotion";

        if(content.contains("lottery") || content.contains("win money"))
            return "Spam";

        return "General";
    }

    @Override
    public String generateReply(String content) {
        return "";
    }
}