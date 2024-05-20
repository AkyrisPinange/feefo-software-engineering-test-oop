package org.feefo.jobtitles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Normalizer {

    private final Map<String, Double> titles;

    public Normalizer(List<String> normalizedTitles) {
        titles = new HashMap<>();
        for (String title : normalizedTitles) {
            titles.put(title, 0.0);
        }
    }

    public String normalize(String inputTitle) {
        String bestMatch = null;
        double bestScore = 0.0;

        // Iterate through the normalized titles to find the best match based on similarity score
        for (String normalizedTitle : titles.keySet()) {
            double score = calculateSimilarity(inputTitle.toLowerCase(), normalizedTitle.toLowerCase());
            if (score > bestScore) {
                bestMatch = normalizedTitle;
                bestScore = score;
            }
        }


        return bestMatch == null ? "has no title found" : bestMatch;
    }

    private double calculateSimilarity(String input, String normalized) {
        int commonWords = 0;

        // Split the input and normalized titles into words
        String[] inputWords = input.split("\\s+");
        String[] normalizedWords = normalized.split("\\s+");

        // Count the number of common words between the input and normalized titles
        for (String inputWord : inputWords) {
            for (String normalizedWord : normalizedWords) {
                if (inputWord.equals(normalizedWord)) {
                    commonWords++;
                    break;
                }
            }
        }

        // Calculate and return the similarity score as the ratio of common words to the maximum length of the input or normalized title
        return (double) commonWords / Math.max(inputWords.length, normalizedWords.length);
    }
}
