package model;

import java.util.Objects;

public class Voter {
    private String voterID;
    private String publicKey;
    private String email;
<<<<<<< HEAD
    private String password;
=======
>>>>>>> 305ecc6303d4bde77aeabf627ba7ca26ffde257f

    public Voter(String voterID, String publicKey) {
        this.voterID = voterID;
        this.publicKey = publicKey;
    }

    // Email
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
<<<<<<< HEAD
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
=======

>>>>>>> 305ecc6303d4bde77aeabf627ba7ca26ffde257f
    // Voter ID
    public String getVoterID() {
        return voterID;
    }

    public void setVoterID(String voterID) {
        this.voterID = voterID;
    }

    // Public Key
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "voterID='" + voterID + '\'' +
                ", email='" + email + '\'' +
                ", publicKey='" + publicKey + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voter)) return false;
        Voter voter = (Voter) o;
        return Objects.equals(email, voter.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
