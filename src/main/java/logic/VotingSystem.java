package logic;

import model.Vote;
import crypto.CryptoUtil;

import java.security.PrivateKey;
import java.util.*;
import java.util.Base64;

public class VotingSystem {
    private final List<Vote> votes = new ArrayList<>();
    private final PrivateKey eaPrivateKey; // Election Authority's private key

    public VotingSystem(PrivateKey eaPrivateKey) {
        this.eaPrivateKey = eaPrivateKey;
    }

    // Adds a vote to the system
    public void addVote(Vote vote) {
        votes.add(vote);
    }

    // Counts all decrypted votes (globally)
    public Map<String, Integer> countVotes() {
        Map<String, Integer> count = new HashMap<>();
        for (Vote v : votes) {
            String decryptedCandidateName = decryptVote(v);
            if (decryptedCandidateName != null) {
                count.put(decryptedCandidateName, count.getOrDefault(decryptedCandidateName, 0) + 1);
            }
        }
        return count;
    }

    // Decrypts a vote using the EA's private key
    private String decryptVote(Vote vote) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(vote.getEncryptedVote());
            byte[] decryptedBytes = CryptoUtil.decrypt(encryptedBytes, eaPrivateKey);
            return new String(decryptedBytes); // candidate name
        } catch (Exception e) {
            System.err.println("Failed to decrypt vote for voter: " + vote.getVoterID());
            return null;
        }
    }
}
