package model;

import java.util.Objects;

public class Vote {
    private String encryptedVote;
    private String voterID;

    public Vote(String encryptedVote, String voterID) {
        this.encryptedVote = encryptedVote;
        this.voterID = voterID;
    }

    // Getters
    public String getEncryptedVote() {
        return encryptedVote;
    }

    public String getVoterID() {
        return voterID;
    }

    // Setters
    public void setEncryptedVote(String encryptedVote) {
        this.encryptedVote = encryptedVote;
    }

    public void setVoterID(String voterID) {
        this.voterID = voterID;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "encryptedVote='" + encryptedVote + '\'' +
                ", voterID='" + voterID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return Objects.equals(voterID, vote.voterID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voterID);
    }
}
