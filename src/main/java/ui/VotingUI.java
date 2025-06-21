package ui;

import model.Vote;
import model.Voter;
import logic.VotingSystem;
import logic.UserManager;
import crypto.CryptoUtil;

import javax.swing.*;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class VotingUI {

    public static void show(Voter voter, VotingSystem system, PublicKey eaPublicKey, PrivateKey privateKey) {
        String[] candidates = UserManager.getCandidates().toArray(new String[0]);

        if (candidates.length == 0) {
            JOptionPane.showMessageDialog(null, "No candidates available. Contact admin.");
            return;
        }

        String choice = (String) JOptionPane.showInputDialog(null,
                "Select your candidate:",
                "Vote",
                JOptionPane.PLAIN_MESSAGE,
                null,
                candidates,
                candidates[0]);

        if (choice != null) {
            try {
                byte[] encrypted = CryptoUtil.encrypt(choice.getBytes(), eaPublicKey);
                String encryptedVote = Base64.getEncoder().encodeToString(encrypted);

                Vote vote = new Vote(encryptedVote, voter.getVoterID());
                system.addVote(vote);
                UserManager.addVote(vote);

                JOptionPane.showMessageDialog(null, "Vote cast successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Encryption error: " + e.getMessage());
            }
        }
    }
}
