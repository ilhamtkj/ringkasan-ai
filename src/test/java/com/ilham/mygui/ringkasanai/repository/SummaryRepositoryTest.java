package com.ilham.mygui.ringkasanai.repository;

import com.ilham.mygui.ringkasanai.model.Summary;
import com.ilham.mygui.ringkasanai.util.TestDatabase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Statement;
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
        // Assertions.assertNotNull(saved.getCreatedAt());
        Assertions.assertNotNull(found.get().getCreatedAt());
    }
}
