package service;

public class PriorityManager {

    public String getPriority(String content) {

        content = content.toLowerCase();

        if(content.contains("urgent")
                || content.contains("asap")
                || content.contains("deadline"))
            return "HIGH";

        return "NORMAL";
    }
}