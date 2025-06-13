package com.ilham.mygui.ringkasanai.service;

import com.ilham.mygui.ringkasanai.model.Summary;
import com.ilham.mygui.ringkasanai.model.SummaryModel;
import com.ilham.mygui.ringkasanai.repository.SummaryRepository;
import com.ilham.mygui.ringkasanai.repository.SummaryRepositoryImpl;
import com.ilham.mygui.ringkasanai.service.formatter.PromtFormatter;
import com.ilham.mygui.ringkasanai.service.formatter.ResultFormatter;
import com.ilham.mygui.ringkasanai.service.mapper.SummaryMapper;
import com.ilham.mygui.ringkasanai.service.summarizer.ApiBasedSummarizer;
import com.ilham.mygui.ringkasanai.service.summarizer.RuleBasedSummarizer;
import com.ilham.mygui.ringkasanai.service.summarizer.Summarizer;
import com.ilham.mygui.ringkasanai.util.Database;

import java.util.ArrayList;
import java.util.List;

public class SummaryService {

    /**
     * melakukan peringkasan.
     * sebelum melakukan peringkasan akan melakukan pemilihan
     * metode peringkasan berdasarkan input user, lalu mengecek
     * jika tidak menggunakan ai maka tidak perlu melakukan
     * format pada teks input.
     *
     * @param text    original teks yang akan diringkas
     * @param method  metode ringkasan, akan menentukan option
     * @param options opsi tambahan untuk teks yang diringkas
     */
    public String generateSummary(String text, String method, String options) {
        // memilih metode summary
        Summarizer summarizer = switch (method.toLowerCase()) {
            case "rule-based" -> new RuleBasedSummarizer();
            case "api-based" -> new ApiBasedSummarizer();
            default -> throw new IllegalArgumentException("Invalid method: " + method);
        };

        String finalPromt = text;
        if (summarizer instanceof ApiBasedSummarizer) {
            finalPromt = PromtFormatter.format(text, options);
        }

        return ResultFormatter.format(summarizer.summarize(finalPromt));
    }

    /**
     * untuk menyimpan ringkasan ke database.
     * method ini membutuhkan teks asli, teks ringkasan
     * dan metode ringkasan. judul atau title akan dibuat dari
     * oroginal teks
     *
     * @param originalText String
     * @param summaryText String
     * @param method String
     */
    public void saveSummary(String originalText, String summaryText, String method) {
        // buat pojo
        Summary summary = new Summary(
                null,
                getTitle(originalText),
                originalText,
                summaryText,
                method,
                null
        );

        SummaryRepository repository = new SummaryRepositoryImpl(Database.getConnection());
        repository.save(summary);
    }

    // untuk mengambil title dari 10 kata pertama teks asli
    private String getTitle(String originalText) {
        int titleLimit = 10;
        // menghilangkan character bukan huruf
        String cleanedText = originalText.replaceAll("[^a-zA-Z0-9\\s]", "").trim();
        // potong tiap kata
        String[] words = cleanedText.split("\\s+");

        titleLimit = Math.min(words.length, titleLimit);
        // gabungkan
        StringBuilder title = new StringBuilder();
        for (int i = 0; i < titleLimit; i++) {
            title.append(words[i]);
            title.append(" ");
        }
        return title.toString().trim();
    }

    /**
     * untuk mengambil data dari db lalu dipakai oleh table.
     *
     * @return SummaryModel
     */
    public List<SummaryModel> getTableData() {
        SummaryRepository repository = new SummaryRepositoryImpl(Database.getConnection());
        List<Summary> dataPOJO = repository.findAll();

        List<SummaryModel> dataModel = new ArrayList<>();
        dataPOJO.forEach(summary -> {dataModel.add(SummaryMapper.toModel(summary));});

        return dataModel;
    }
}
