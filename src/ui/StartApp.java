package ui;

import service.AuthService;

public class StartApp {

    public static void main(String[] args) {

        AuthService auth = new AuthService();

        new SignupGUI(auth); // first sign up screen
    }
}