package org.laboratories.scuirty_lw1_var6;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

public class Auth {

    private Map<String, String> users;
    private Map<String, char[][]> matrices;

    public Auth() {

        users = new HashMap<>();
        matrices = new HashMap<>();

        try {

            registerUser("войтюк", "монстя");

        } catch (AuthenticationException err) {

            System.out.println(err.getMessage());
        }
    }

    public void registerUser(String username, String password) throws AuthenticationException {

        if (users.containsKey(username)) {

            throw new AuthenticationException("A user with this username is already registered");
        }

        PlayfairCipher playfairCipher = new PlayfairCipher();

        String key = username.toLowerCase();
        key = playfairCipher.removeDuplicates(key);

        char[][] matrix = playfairCipher.generateMatrix(key);
        matrices.put(username, matrix);

        password = password.toLowerCase();
        password = playfairCipher.insertPlaceholder(password);
        password = playfairCipher.encryptPassword(matrix, password);

        users.put(username, password);
    }

    public boolean authUser(String username, String password) throws AuthenticationException {

        if (!users.containsKey(username)) {

            throw new AuthenticationException("The user with this username does not exist");

        }

        PlayfairCipher playfairCipher = new PlayfairCipher();

        password = password.toLowerCase();
        char[][] matrix = matrices.get(username);
        String encryptedPassword = users.get(username);

        if (!playfairCipher.decryptPassword(matrix, encryptedPassword).equals(password)) {

            throw new AuthenticationException("The password is wrong");

        } else {

            return true;
        }


    }
}
