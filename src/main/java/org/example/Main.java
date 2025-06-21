package org.example;

import logic.VotingSystem;
import ui.LoginUI;
import crypto.KeyGeneratorUtil;

import java.security.KeyPair;

public class Main {
    public static void main(String[] args) {
        try {
            // EA key pair
            KeyPair eaKeyPair = KeyGeneratorUtil.generateKeyPair();
            VotingSystem system = new VotingSystem(eaKeyPair.getPrivate());

            // Pass EA public key to LoginUI
            while (true) {
                boolean continueApp = LoginUI.show(system, eaKeyPair.getPublic());
                if (!continueApp) break;
            }

            System.out.println("Application closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
