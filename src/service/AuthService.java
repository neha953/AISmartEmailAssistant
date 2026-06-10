package service;

import java.util.HashMap;

public class AuthService {

    // username -> hashed password
    private HashMap<String, String> users = new HashMap<>();

    // SIGN UP (store hashed password)
    public boolean register(String username, String password) {

        if (users.containsKey(username)) {
            return false;
        }

        String hashedPassword = PasswordUtil.hashPassword(password);

        users.put(username, hashedPassword);

        return true;
    }

    // LOGIN (compare hashed passwords)
    public boolean login(String username, String password) {

        if (!users.containsKey(username)) {
            return false;
        }

        String hashedInput = PasswordUtil.hashPassword(password);

        return users.get(username).equals(hashedInput);
    }
}