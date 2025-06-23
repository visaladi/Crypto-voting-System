# Crypto-voting-System
# 🗳️ Secure Voting System - Java (Swing + JSON)

A **Java-based secure electronic voting system** built for educational or small-scale elections. It provides a graphical interface for voters to register and cast votes securely, while allowing an admin to manage candidates, register voters, and count votes county-wise. All data is stored in a JSON file.

---

## 🚀 Features

- 🔐 **Admin Login** (`admin / admin123`)
- 👤 **User Registration** (Email, Username, County)
- 🧾 **Candidate Management** (Add new candidates)
- 🗳️ **Vote Casting** (Sign and encrypt mechanism)
- 📊 **County-wise Vote Counting**
- 💾 **Data Persistence** via `data.json`

---

## 🏗️ Tech Stack

- **Java 17+**
- **Java Swing** for GUI
- **Gson** for JSON serialization/deserialization
- **RSA Encryption** (for vote confidentiality)
- **Signature Verification** (vote integrity & authentication)

---

## 📁 File Structure

src/
├── model/
│ ├── Voter.java
│ ├── Vote.java
│ └── Candidate.java
├── crypto/
│ ├── CryptoUtil.java
│ └── KeyGeneratorUtil.java
├── logic/
│ ├── VotingSystem.java
│ └── DataStore.java
├── ui/
│ ├── LoginUI.java
│ ├── RegisterUI.java
│ ├── VotingUI.java
│ └── AdminUI.java
└── Main.java

resources/
└── data.json

yaml
Copy
Edit

---

## 🔐 Security Protocol Used

The project uses the **Sign-Then-Encrypt** strategy:

1. **Voter signs** the vote with their private key.
2. **Vote + Signature** is **encrypted** using the Election Authority's public key.
3. Encrypted payload is stored in `data.json`.
4. Admin decrypts & verifies the vote before counting.

---

## 📍 Local Setup

1. **Clone the repository**

  bash
   git clone https://github.com/your-username/secure-voting-system-java.git
   cd secure-voting-system-java
Ensure Java 17+ is installed

Add Gson Library

If using an IDE, add gson-2.10.1.jar to your classpath.

Or use Maven:

xml
Copy
Edit
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
Run the application

Run Main.java

## 📝 Notes
Admin credentials are hardcoded: admin / admin123

##  All votes, voters, and candidates are persisted in:

mathematica

C:\Users\visal Adikari\OneDrive\Desktop\uni sem4\web application\springboort\08-24-01\First\isproject\src\main\resources\data.json
 ```
📌 Future Improvements
✅ Add password hashing for registered users

✅ RSA key generation per voter

✅ Blockchain-based immutable vote storage

✅ Switch to JavaFX for modern UI

🧑‍💻 Author
Visal Sandeep Adikari
University of Ruhuna, Sri Lanka
LinkedIn | GitHub
