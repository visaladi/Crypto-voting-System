package logic;

import com.google.gson.*;
import model.Vote;
import model.Voter;

import java.io.*;
import java.util.*;

public class UserManager {

    private static final String FILE_PATH =
            "C:\\Users\\visal Adikari\\OneDrive\\Desktop\\uni sem4\\web application\\springboort\\08-24-01\\First\\isproject\\src\\main\\resources\\data.json";

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static class DataStore {
        public List<Voter> users = new ArrayList<>();
        public List<String> candidates = new ArrayList<>();
        public List<Vote> votes = new ArrayList<>();
    }

    private static DataStore dataStore;

    static {
        loadData();
    }

    private static void loadData() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            dataStore = gson.fromJson(reader, DataStore.class);
            if (dataStore == null) {
                dataStore = new DataStore();
            }
        } catch (IOException e) {
            dataStore = new DataStore();
        }
    }

    public static void saveData() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(dataStore, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean registerUser(Voter voter) {
        for (Voter v : dataStore.users) {
            if (v.getEmail().equalsIgnoreCase(voter.getEmail())) return false;
        }
        dataStore.users.add(voter);
        saveData();
        return true;
    }

    public static Voter getUser(String email) {
        for (Voter v : dataStore.users) {
            if (v.getEmail().equalsIgnoreCase(email)) return v;
        }
        return null;
    }

    public static void addCandidate(String name) {
        if (!dataStore.candidates.contains(name)) {
            dataStore.candidates.add(name);
            saveData();
        }
    }

    public static List<String> getCandidates() {
        return dataStore.candidates;
    }

    public static void addVote(Vote vote) {
        dataStore.votes.add(vote);
        saveData();
    }

    public static List<Vote> getAllVotes() {
        return new ArrayList<>(dataStore.votes);
    }

    public static List<Voter> getAllUsers() {
        return new ArrayList<>(dataStore.users);
    }
}
