package com.ilham.mygui.ringkasanai.service.summarizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleBasedSummarizer implements Summarizer{
    private static final int NUM_SENTENCE = 3;

    @Override
    public String summarize(String text) {
        // pisah teks per kalimat
        String[] sentences = text.split("(?<=[.!?])\\s+");

        // menghitung frekuensi kata
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String sentence : sentences) {
            for (String word : sentence.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+")) {
                if (word.length() > 2) { // abaikan kata terlalu pendek
                    wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                }
            }
        }

        // menghitung skor untuk setiap kalimat
        Map<String, Integer> sentenceScores = new HashMap<>();
        for (String sentence : sentences) {
            int score = 0;
            for (String word : sentence.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+")) {
                score += wordFreq.getOrDefault(word, 0);
            }
            sentenceScores.put(sentence, score);
        }

        // ambil kalimat dengan skor tertinggi
        List<String> topSentences = sentenceScores.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue()) // descending
                .limit(NUM_SENTENCE)
                .map(Map.Entry::getKey)
                .toList();

        // gabungkan kalimat
        return String.join(" ", topSentences);
    }
}
