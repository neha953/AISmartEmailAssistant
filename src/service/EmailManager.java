package service;

import java.util.*;
import model.Email;

public class EmailManager {

    private ArrayList<Email> emails = new ArrayList<>();

    public void addEmail(Email email) {
        emails.add(email);
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    // Display
    public ArrayList<Email> getAll() {
        return emails;
    }

    // Search
    public void searchBySender(String sender) {

        boolean found = false;

        for (Email e : emails) {
            if (e.getSender().equalsIgnoreCase(sender)) {
                e.displayEmail();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No email found.");
        }
    }

    // Delete
    public void deleteEmail(int index) {

        if (index >= 0 && index < emails.size()) {
            emails.remove(index);
            System.out.println("Email deleted successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Statistics
    public void showStatistics() {

        int total = emails.size();
        int work = 0, spam = 0, finance = 0, promo = 0;

        for (Email e : emails) {

            String cat = e.getCategory();

            if (cat.equalsIgnoreCase("Work")) work++;
            else if (cat.equalsIgnoreCase("Spam")) spam++;
            else if (cat.equalsIgnoreCase("Finance")) finance++;
            else if (cat.equalsIgnoreCase("Promotion")) promo++;
        }

        System.out.println("\n===== STATS =====");
        System.out.println("Total Emails: " + total);
        System.out.println("Work: " + work);
        System.out.println("Spam: " + spam);
        System.out.println("Finance: " + finance);
        System.out.println("Promotion: " + promo);
    }

    // Sorting by importance (AI feel)
    public void sortEmails() {

        emails.sort((a, b) -> Boolean.compare(b.isImportant(), a.isImportant()));
    }
}