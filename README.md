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

```text
src/
├── Main.java              # Application entry point
├── Chatbot.java           # Core chatbot logic
├── FAQData.java           # Stores questions & answers
├── SimilarityUtils.java   # Text similarity functions
└── HintTextField.java     # Custom UI input field
```
---

## ⚙️ How It Works

1. User enters a question in the chat interface
2. Input text is processed and cleaned
3. Similarity algorithms compare input with stored FAQ questions
4. The closest matching question is selected
5. The corresponding answer is displayed to the user

---

## ▶️ How to Run
1. Clone the repository
   git clone https://github.com/aradhya-kumar/benne10-chatbot.git
2. Open the project in any Java IDE (IntelliJ / Eclipse / VS Code)
3. Run **Main.java**

---

## 👤 Author

Aradhya Kumar Rao
Linkedin: https://www.linkedin.com/in/aradhya-kumar
GitHub: https://github.com/aradhya-kumar


