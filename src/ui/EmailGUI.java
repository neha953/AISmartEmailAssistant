package ui;

import javax.swing.*;
import java.awt.*;
import model.Email;
import service.*;

public class EmailGUI extends JFrame {

    private JTextField senderField, subjectField;
    private JTextArea contentArea, outputArea;

    private EmailManager manager = new EmailManager();
    private EmailCategorizer categorizer = new EmailCategorizer();
    private ReplyGenerator replyGenerator = new ReplyGenerator();
    private PriorityManager priorityManager = new PriorityManager();
    private FileService fileService = new FileService();

    public EmailGUI() {

        setTitle("AI Smart Email Assistant");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        senderField = new JTextField(20);
        subjectField = new JTextField(20);
        contentArea = new JTextArea(5, 40);

        JButton addBtn = new JButton("Add Email");
        JButton viewBtn = new JButton("View Emails");
        JButton saveBtn = new JButton("Save");
        JButton loadBtn = new JButton("Load");

        outputArea = new JTextArea(15, 50);
        outputArea.setEditable(false);

        add(new JLabel("Sender"));
        add(senderField);

        add(new JLabel("Subject"));
        add(subjectField);

        add(new JLabel("Content"));
        add(contentArea);

        add(addBtn);
        add(viewBtn);
        add(saveBtn);
        add(loadBtn);
        add(new JScrollPane(outputArea));

        // ADD EMAIL
        addBtn.addActionListener(e -> {

            Email email = new Email(
                    senderField.getText(),
                    subjectField.getText(),
                    contentArea.getText()
            );

            if (contentArea.getText().toLowerCase().contains("urgent")) {
                email.setImportant(true);
            }

            email.setCategory(categorizer.categorizeEmail(contentArea.getText()));

            manager.addEmail(email);

            outputArea.setText("Email Added!\n" +
                    "Category: " + email.getCategory() + "\n" +
                    "Reply: " + replyGenerator.generateReply(contentArea.getText()));
        });

        // VIEW EMAILS
        viewBtn.addActionListener(e -> {

            manager.sortEmails();

            StringBuilder sb = new StringBuilder();

            for (Email em : manager.getEmails()) {
                sb.append(em.getSender())
                  .append(" | ")
                  .append(em.getSubject())
                  .append(" | ")
                  .append(em.getCategory())
                  .append(" | Important: ")
                  .append(em.isImportant())
                  .append("\n");
            }

            outputArea.setText(sb.toString());
        });

        // SAVE
        saveBtn.addActionListener(e -> {
            fileService.saveEmails(manager.getEmails());
        });

        // LOAD
        loadBtn.addActionListener(e -> {

            manager.getEmails().clear();
            manager.getEmails().addAll(fileService.loadEmails());

            outputArea.setText("Emails Loaded Successfully!");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new EmailGUI();
    }
}