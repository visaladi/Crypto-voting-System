package ui;

import logic.UserManager;
import model.Voter;
import logic.VotingSystem;

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
                Voter voter = UserManager.getUser(email);
                if (voter == null) {
                    JOptionPane.showMessageDialog(null, "User not found. Please register.");
                    break;
                }

                try {
                    KeyPair keyPair = KeyGeneratorUtil.generateKeyPair();
                    PrivateKey privateKey = keyPair.getPrivate();

                    // voter public key not needed here anymore
                    VotingUI.show(voter, system, eaPublicKey, privateKey);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error during login: " + e.getMessage());
                }
                break;

            case "Register":
                String regEmail = JOptionPane.showInputDialog("Enter your email:");
                String username = JOptionPane.showInputDialog("Enter your username:");

                if (regEmail == null || username == null) {
                    JOptionPane.showMessageDialog(null, "Registration cancelled.");
                    break;
                }

                try {
                    KeyPair regKeyPair = KeyGeneratorUtil.generateKeyPair();
                    String publicKeyBase64 = Base64.getEncoder().encodeToString(regKeyPair.getPublic().getEncoded());

                    Voter newVoter = new Voter(username, publicKeyBase64);
                    newVoter.setEmail(regEmail);

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

        return true; // Go back to role selection after action
    }
}
