package com.ilham.mygui.ringkasanai.service.formatter;

import java.util.ArrayList;
import java.util.List;

public class Formatter {

    /**
     * memformat teks supaya sesuai.
     * format melakukan operasi penghapusan white space berlebih,
     * memotong motong teks ketika mendapat newline,
     * teks yang sudah dipotong akan digabungkan jika
     * tidak terdapat tanda baca akhir (titik, tanda seru, tanda tanya),
     * buat huruf awal kalimat menjadi kapital.
     *
     * @param text String
     * @return String
     */
    public String format(String text) {
        if (text == null || text.isBlank()) return "";

        String normalized = normalizeWhitespace(text);
        String[] lines = splitLines(normalized);
        List<String> merged = mergeLines(lines);
        List<String> capitalized = capitalizeLines(merged);

        return String.join("\n", capitalized).trim();
    }

    // menghapus tab/spasi berlebih dan newline acak
    private String normalizeWhitespace(String input) {
        return input
                .replaceAll("[ \\t\\x0B\\f\\r]+", " ") // tab dan semacamnya
                .replaceAll(" +", " ") // spasi berlebih
                .trim();
    }

    // pisah teks berdasarkan newline
    private String[] splitLines(String input) {
        return input.split("\\R+");
    }

    // gabungkan baris jika baris tidak diakhiri tanda baca akhir
    private List<String> mergeLines(String[] lines) {
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            line = line.trim();

            if (result.isEmpty()) {
                result.add(line);
                continue;
            }

            String last = result.getLast();
            if (endsWithPunctuation(last)) {
                result.add(line);
            } else {
                String merged = last.isBlank() ? line : last + " " + line;
                result.set(result.size() - 1, merged.trim());
            }
        }

        return result;
    }

    // mengecek apakah akhir kalimat adalah tanda akhir
    private boolean endsWithPunctuation(String text) {
        return text.endsWith(".") || text.endsWith("!") || text.endsWith("?");
    }

    // kapital di awal setiap baris
    private List<String> capitalizeLines(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add(capitalizeFirstLetter(line));
        }
        return result;
    }

    // kapital huruf pertama
    private String capitalizeFirstLetter(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLetter(sentence.charAt(i))) {
                return sentence.substring(0, i)
                        + Character.toUpperCase(sentence.charAt(i))
                        + sentence.substring(i + 1);
            }
        }
        return sentence;
    }
}