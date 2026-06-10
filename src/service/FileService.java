package service;

import java.io.*;
import java.util.*;
import model.Email;

public class FileService {

    private String fileName = "emails.txt";

    public void saveEmails(List<Email> emails) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            for (Email e : emails) {
                bw.write(
                    e.getSender() + "," +
                    e.getSubject() + "," +
                    e.getContent() + "," +
                    e.getCategory() + "," +
                    e.isImportant()
                );
                bw.newLine();
            }

            System.out.println("Emails saved to file.");

        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    public List<Email> loadEmails() {

        List<Email> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Email e = new Email(data[0], data[1], data[2]);
                e.setCategory(data[3]);
                e.setImportant(Boolean.parseBoolean(data[4]));

                list.add(e);
            }

        } catch (Exception e) {
            System.out.println("No file found or error loading.");
        }

        return list;
    }
}