package ui;

import logic.UserManager;
import model.Voter;
import logic.VotingSystem;
<<<<<<< HEAD
import crypto.SecurityUtil;
=======
>>>>>>> 305ecc6303d4bde77aeabf627ba7ca26ffde257f

import javax.swing.*;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import crypto.KeyGeneratorUtil;

public class LoginUI {

    public static boolean show(VotingSystem system, PublicKey eaPublicKey) {
        String[] options = {"Admin Login", "User Login", "Register", "Exit"};
        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Choose an option:",
                "Login Menu",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == null || "Exit".equals(choice)) {
            return false;
        }

        switch (choice) {
            case "Admin Login":
                String password = JOptionPane.showInputDialog("Enter Admin Password:");
                if ("admin123".equals(password)) {
                    JOptionPane.showMessageDialog(null, "Admin logged in successfully!");
                    AdminUI.show(system);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect password!");
                }
                break;

            case "User Login":
                String email = JOptionPane.showInputDialog("Enter your registered email:");
<<<<<<< HEAD
                String inputPassword = JOptionPane.showInputDialog("Enter your password:");

=======
>>>>>>> 305ecc6303d4bde77aeabf627ba7ca26ffde257f
                Voter voter = UserManager.getUser(email);
                if (voter == null) {
                    JOptionPane.showMessageDialog(null, "User not found. Please register.");
                    break;
                }

<<<<<<< HEAD
                // ✅ Check hashed password
                if (!voter.getPassword().equals(SecurityUtil.hashPassword(inputPassword))) {
                    JOptionPane.showMessageDialog(null, "Incorrect password.");
                    break;
                }

                try {
                    KeyPair keyPair = KeyGeneratorUtil.generateKeyPair();
                    PrivateKey privateKey = keyPair.getPrivate();
=======
                try {
                    KeyPair keyPair = KeyGeneratorUtil.generateKeyPair();
                    PrivateKey privateKey = keyPair.getPrivate();

                    // voter public key not needed here anymore
>>>>>>> 305ecc6303d4bde77aeabf627ba7ca26ffde257f
                    VotingUI.show(voter, system, eaPublicKey, privateKey);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error during login: " + e.getMessage());
                }
                break;

            case "Register":
                String regEmail = JOptionPane.showInputDialog("Enter your email:");
                String username = JOptionPane.showInputDialog("Enter your username:");
<<<<<<< HEAD
                String regPassword = JOptionPane.showInputDialog("Enter your password:");
                if (regEmail == null || username == null || regPassword == null) {
=======

                if (regEmail == null || username == null) {
>>>>>>> 305ecc6303d4bde77aeabf627ba7ca26ffde257f
                    JOptionPane.showMessageDialog(null, "Registration cancelled.");
                    break;
                }

                try {
                    KeyPair regKeyPair = KeyGeneratorUtil.generateKeyPair();
                    String publicKeyBase64 = Base64.getEncoder().encodeToString(regKeyPair.getPublic().getEncoded());

                    Voter newVoter = new Voter(username, publicKeyBase64);
                    newVoter.setEmail(regEmail);
<<<<<<< HEAD
                    newVoter.setPassword(SecurityUtil.hashPassword(regPassword)); // ✅ Store hashed password
=======
>>>>>>> 305ecc6303d4bde77aeabf627ba7ca26ffde257f

                    if (UserManager.registerUser(newVoter)) {
                        JOptionPane.showMessageDialog(null, "Registration successful!");
                    } else {
                        JOptionPane.showMessageDialog(null, "User already exists.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error during registration: " + e.getMessage());
                }
                break;
        }

<<<<<<< HEAD
        return true;
=======
        return true; // Go back to role selection after action
>>>>>>> 305ecc6303d4bde77aeabf627ba7ca26ffde257f
    }
}
