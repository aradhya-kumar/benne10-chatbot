package com.cerebro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;

public class Main {
    private static JTextArea chatArea; 
    private static JTextField inputField; 
    private static Chatbot bot; 
    private static JScrollPane scrollPane; 

    public static void main(String[] args) throws IOException {
        // Load the FAQ data from the CSV file
        List<FAQData.QA> data = FAQData.loadData("faq.csv");
        bot = new Chatbot(data); 

        // Create the main window frame
        JFrame frame = new JFrame("BenT10 - Chatbot");
        frame.setSize(600, 700); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLocationRelativeTo(null); 
        frame.setLayout(new BorderLayout()); 

        // Define the colors for the interface
        Color backgroundColor = new Color(18, 18, 18);
        Color textColor = new Color(220, 220, 220);     
        Color accentColor = new Color(0, 153, 255);     

        ImageIcon logo = new ImageIcon("C:\\Users\\Aradhya Kumar Rao\\Desktop\\ChatBot_2.0\\csv-chatbot\\src\\main\\java\\com\\cerebro\\logo.png");
        frame.setIconImage(logo.getImage());

        // Set up the chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false); 
        chatArea.setFont(new Font("Consolas", Font.PLAIN, 16)); 
        chatArea.setBackground(backgroundColor); 
        chatArea.setForeground(textColor); 
        chatArea.setLineWrap(true); 
        chatArea.setWrapStyleWord(true); 
        chatArea.setCaretColor(textColor); 

        // Set up the scroll pane for the chat area
        scrollPane = new JScrollPane(chatArea);
        scrollPane.setBackground(backgroundColor); 
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        // Set up the input panel (where the input field and send button are placed)
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(backgroundColor); 
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        // Set up the input field with placeholder text
        inputField = new JTextField();
        inputField.setFont(new Font("Consolas", Font.PLAIN, 16)); 
        inputField.setBackground(new Color(30, 30, 30)); 
        inputField.setForeground(Color.GRAY); 
        inputField.setCaretColor(Color.WHITE); 
        inputField.setText("Ask anything..."); 
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(accentColor, 1), 
                BorderFactory.createEmptyBorder(8, 8, 8, 8) 
        ));
        inputField.setPreferredSize(new Dimension(0, 40)); 

        // Handle placeholder text behavior
        inputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputField.getText().equals("Ask anything...")) {
                    inputField.setText(""); 
                    inputField.setForeground(Color.WHITE); 
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputField.getText().isEmpty()) {
                    inputField.setForeground(Color.GRAY); 
                    inputField.setText("Ask anything..."); 
                }
            }
        });

        // Set up the send button
        JButton sendButton = new JButton("Send");
        sendButton.setFont(new Font("Consolas", Font.BOLD, 20)); 
        sendButton.setBackground(accentColor); 
        sendButton.setForeground(Color.WHITE); 
        sendButton.setFocusPainted(false); 
        sendButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15)); 

        // Send message when the button is clicked or the Enter key is pressed
        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        // Add components to the input panel
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Add the chat area and input panel to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        // Set the window visible
        frame.setVisible(true);

        // Display a welcome message when the app starts
        appendBotMessage("Welcome to BenT10! How can I assist you today?");
    }

    private static void sendMessage() {
        String input = inputField.getText().trim(); 
        if (input.isEmpty() || input.equals("Ask anything...")) return; 

        appendUserMessage(input); 
        inputField.setText("");
        // Check for greetings
        if (input.equalsIgnoreCase("hi") || input.equalsIgnoreCase("hello")) {
            appendBotMessage("Hello there! How can I assist you today?");
            return;
        }    
        // Check if the user wants to exit the chat
        if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("bye") || input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("close")) {
            appendBotMessage("Goodbye! "); 
            JOptionPane.showMessageDialog(null, "Goodbye! Closing BenT10..."); 
            System.exit(0); 
        }

        // If the user expresses thanks, respond appropriately
        if (input.toLowerCase().contains("thank you") || input.toLowerCase().contains("thanks")) {
            appendBotMessage("You're welcome! Anything else you would like to know?");
            return;
        }

        // Get the bot's response and display it
        String response = bot.getAnswer(input);
        appendBotMessage(response);
    }

    private static void appendUserMessage(String message) {
      
        chatArea.append("You : " + message + "\n\n");
        scrollToBottom(); 
    }

    private static void appendBotMessage(String message) {
        // Append the bot's message to the chat area
        chatArea.append("BenT10 : " + message + "\n\n");
        scrollToBottom(); 
    }

    private static void scrollToBottom() {
        // Scroll the chat area to the bottom so the latest message is visible
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }
}
