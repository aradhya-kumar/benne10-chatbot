# Benne10 ChatBot 🤖

A Java-based Question Answering chatbot designed to respond to user queries using
intent matching and text similarity techniques.

---

## 🔍 Overview

Benne10 ChatBot is a desktop-based chatbot application built in **Java**.  
It processes user input, compares it with predefined questions, and returns the most
relevant response using similarity scoring.

The chatbot is designed for **clarity, modularity, and extendability**, making it easy
to add new data or improve matching logic.

---

## 🧠 How It Works

1. User enters a query in the GUI
2. Input is cleaned and processed
3. Similarity is calculated against stored questions
4. Best-matching answer is returned
5. If no match is strong enough, a fallback response is shown

---

## 🛠️ Technologies Used

- **Java**
- **Java Swing** (GUI)
- **String similarity algorithms**
- **CSV / in-memory data storage**
- Object-Oriented Programming (OOP)

---

## 📁 Project Structure
src/
├── Main.java # Application entry point
├── Chatbot.java # Core chatbot logic
├── FAQData.java # Stores questions & answers
├── SimilarityUtils.java # Text similarity functions
└── HintTextField.java # Custom UI input field
