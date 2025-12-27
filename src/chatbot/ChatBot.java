package com.cerebro;

import com.cerebro.FAQData;
import com.cerebro.SimilarityUtils;
import java.util.*;

public class Chatbot {
    // List to store FAQ question-answer pairs
    private List<FAQData.QA> faqList;

    // Constructor initializes the chatbot with a list of FAQs
    public Chatbot(List<FAQData.QA> faqList) {
        this.faqList = faqList;
    }

    // Method to get the best-matching answer for a user question
    public String getAnswer(String userQuestion) {
        // Convert user question into a frequency vector
        Map<String, Integer> inputVec = SimilarityUtils.tokenize(userQuestion);

        // Initialize best score and default response
        double bestScore = -1;
        String bestAnswer = "I'm not sure I understand. Can you rephrase?";

        // Loop through all stored FAQs
        for (FAQData.QA qa : faqList) {
            // Convert the FAQ question into a frequency vector
            Map<String, Integer> questionVec = SimilarityUtils.tokenize(qa.question);

            // Calculate cosine similarity between user question and this FAQ question
            double score = SimilarityUtils.cosineSimilarity(inputVec, questionVec);

            if (score > bestScore) {
                bestScore = score;
                bestAnswer = qa.answer;
            }
        }

        return bestAnswer;
    }
}
