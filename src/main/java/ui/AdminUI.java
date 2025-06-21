package ui;

import logic.UserManager;
import logic.VotingSystem;
import model.Voter;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AdminUI {

    public static void show(VotingSystem system) {
        while (true) {
            String[] options = {"Add Candidate", "Count Votes", "View Registered Users", "Exit"};
            String action = (String) JOptionPane.showInputDialog(null,
                    "Select an admin action:",
                    "Admin Panel",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (action == null || "Exit".equals(action)) {
                JOptionPane.showMessageDialog(null, "Exiting Admin Panel.");
                break;
            }

            switch (action) {
                case "Add Candidate":
                    String name = JOptionPane.showInputDialog("Enter candidate name:");
                    if (name != null && !name.isBlank()) {
                        UserManager.addCandidate(name.trim());
                        JOptionPane.showMessageDialog(null, "Candidate added.");
                    }
                    break;

                case "Count Votes":
                    Map<String, Integer> result = system.countVotes();
                    if (result.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No votes have been recorded.");
                    } else {
                        Map<String, Integer> sorted = new TreeMap<>(result);
                        StringBuilder sb = new StringBuilder("Global Vote Results:\n\n");
                        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
                            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append(" votes\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                    break;

                case "View Registered Users":
                    List<Voter> users = UserManager.getAllUsers();
                    if (users.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No registered users found.");
                    } else {
                        StringBuilder sb = new StringBuilder("Registered Users:\n\n");
                        for (Voter v : users) {
                            sb.append("Email: ").append(v.getEmail())
                                    .append(", Username: ").append(v.getVoterID()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                    break;
            }
        }
    }
}
