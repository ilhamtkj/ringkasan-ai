package com.ilham.mygui.ringkasanai.repository;

import com.ilham.mygui.ringkasanai.model.Summary;
import com.ilham.mygui.ringkasanai.util.TestDatabase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class SummaryRepositoryTest {
    private static SummaryRepository repository;

    @BeforeAll
    static void setupDatabase() throws Exception {
        repository = new SummaryRepositoryImpl(TestDatabase.getConnection());
    }

    @AfterAll
    static void tearDownDatabase() throws Exception {
        // Bersihkan data setelah test
        try (Connection conn = TestDatabase.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM summaries");
        }
    }

    @Test
    void testSaveAndFinfById() {
        Summary summary = new Summary(null, "lorem ipsum", "teks asli yang masih panjang", "teks yang sudah diringkas", "Test", null);
        Summary saved = repository.save(summary);

        Optional<Summary> found = repository.findById(saved.getId());
        Assertions.assertTrue(found.isPresent());
        Assertions.assertEquals(saved.getId(), found.get().getId());
        Assertions.assertEquals(saved.getTitle(), found.get().getTitle());
        Assertions.assertEquals(saved.getOriginalText(), found.get().getOriginalText());
        Assertions.assertEquals(saved.getSummaryText(), found.get().getSummaryText());
        Assertions.assertEquals(saved.getMethod(), found.get().getMethod());
        Assertions.assertNotNull(saved.getCreatedAt());
        Assertions.assertNotNull(found.get().getCreatedAt());
    }

    @Test
    void findAll() {
        // dummy data
        var summary1 = new Summary(null, "title 1", "original text", "summary text", "method", null);
        var summary2 = new Summary(null, "title 2", "original text", "summary text", "method", null);
        var s1 = repository.save(summary1);
        var s2 = repository.save(summary2);

        var result = repository.findAll();
        List<Summary> resultList = repository.findAll();

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertFalse(resultList.isEmpty());
        Assertions.assertEquals(2, result.size());

        result.forEach(s -> System.out.println(s.getId() + " " + s.getTitle() + " " + s.getOriginalText() + " " + s.getSummaryText() + " " + s.getMethod() + " " + s.getCreatedAt()));

        Assertions.assertEquals(s1.getId(), result.get(0).getId());
        Assertions.assertEquals(s2.getId(), result.get(1).getId());
        Assertions.assertEquals(s1.getTitle(), result.get(0).getTitle());
        Assertions.assertEquals(s2.getTitle(), result.get(1).getTitle());
    }

    @Test
    void findByIdTest() {
        Summary summary = new Summary(null, "title", "original teks", "summary teks", "Test", null);
        Summary saved = repository.save(summary);
        Optional<Summary> found = repository.findById(summary.getId());

        found.ifPresentOrElse(s -> System.out.println(s.getId() + " " + s.getTitle() + " " + s.getOriginalText() + " " + s.getSummaryText() + " " + s.getMethod() + " " + s.getCreatedAt()), () -> System.out.println("Data tidak ditemukan!"));
    }
}
