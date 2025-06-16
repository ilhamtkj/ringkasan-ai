package com.ilham.mygui.ringkasanai.service.summarizer;

import java.text.BreakIterator;
import java.util.*;

public class RuleBasedSummarizer implements Summarizer{
    // default panjang kalimat 3
    private int numSentence = 3;

    @Override
    public String summarize(String formattedText) {
        // memisah teks menjadi kalimat dan menentukan panjang ringkasan
        double lengthOption = parseLength(formattedText);
        List<String> sentences = breakText(parseText(formattedText));
        calculateLength(sentences, lengthOption);

        // testing
        System.out.println(sentences.size());
        System.out.println(numSentence);

        // skor kalimat
        Map<String, Integer> sentenceScores = getSentenceScores(sentences);

        // ambil kalimat dengan skor tertinggi
        List<String> topSentences = sentenceScores.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue()) // descending
                .limit(numSentence)
                .map(Map.Entry::getKey)
                .toList();

        // gabungkan kalimat
        return String.join(" ", topSentences);
    }

    // untuk menghitung skor tiap kalimat
    private static Map<String, Integer> getSentenceScores(List<String> sentences) {
        // menghiting skor kata
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
        return sentenceScores;
    }

    // untuk mengambil teksnya saja
    private String parseText(String text) {
        if (text.startsWith("(panjang)")) {
            return text.substring("(panjang)".length()).trim();
        } else if (text.startsWith("(pendek)")) {
            return text.substring("(pendek)".length()).trim();
        }
        return text;
    }

    // untuk mengambil panjang ringkasan
    private double parseLength(String text) {
        if (text.startsWith("(panjang)")) {
            return 0.5;
        } else if (text.startsWith("(pendek)")) {
            return 0.25;
        }
        return 0.5;
    }

    // memisah teks menjadi kalimat
    private List<String> breakText(String text) {
        List<String> sentences = new ArrayList<>();

        Locale locale = new Locale.Builder().setLanguage("id").setRegion("ID").build();
        BreakIterator iterator =  BreakIterator.getSentenceInstance(locale);
        iterator.setText(text);
        int start = iterator.first();
        for (int end = iterator.next(); end != BreakIterator.DONE;  start = end, end = iterator.next()) {
            String sentence = text.substring(start, end).trim();
            if (!sentence.isEmpty()) {
                sentences.add(sentence);
            }
        }
        return sentences;
    }

    // kalkulasi panjang teks/limit berapa kalimat
    private void calculateLength(List<String> sentences, double length) {
        numSentence = (int)Math.ceil(sentences.size() * length);
    }
}
