package com.cerebro;

import java.util.*;

public class SimilarityUtils {

    // Calculates cosine similarity between two word frequency maps
    public static double cosineSimilarity(Map<String, Integer> vec1, Map<String, Integer> vec2) {
        // Combine all unique words from both vectors
        Set<String> allWords = new HashSet<>();
        allWords.addAll(vec1.keySet());
        allWords.addAll(vec2.keySet());

        // Initialize components of the cosine similarity formula
        double dotProduct = 0.0, normA = 0.0, normB = 0.0;

        
        for (String word : allWords) {
            int a = vec1.getOrDefault(word, 0); 
            int b = vec2.getOrDefault(word, 0); 
            dotProduct += a * b;
            normA += Math.pow(a, 2);            
            normB += Math.pow(b, 2);            
        }

        // If either vector is empty, similarity is 0
        return (normA == 0 || normB == 0) ? 0 : dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    // Converts a sentence into a frequency map of lowercase words
    public static Map<String, Integer> tokenize(String text) {
        Map<String, Integer> freq = new HashMap<>();

        // Split input text into words using non-word characters as delimiters
        for (String word : text.toLowerCase().split("\\W+")) {
            if (!word.isBlank()) {
                // Increase the count for each word in the frequency map
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }
        return freq;
    }
}
