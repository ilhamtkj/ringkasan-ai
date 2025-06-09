package com.ilham.mygui.ringkasanai.repository;

import com.ilham.mygui.ringkasanai.model.Summary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SummaryRepositoryImpl implements SummaryRepository {

    // koneksi
    private final Connection connection;

    /**
     * untuk koneksi
     *
     * @param connection masukan koneksi ke parameter
     */
    public SummaryRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * save mengembalikan objek summary dengan value id
     * yang sudah diperbarui.
     *
     * @param summary
     * @return
     */
    @Override
    public Summary save(Summary summary) {
        String sql = "INSERT INTO summaries (title, original_text, summary_text, method) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // binding
            stmt.setString(1, summary.getTitle());
            stmt.setString(2, summary.getOriginalText());
            stmt.setString(3, summary.getSummaryText());
            stmt.setString(4, summary.getMethod());
            stmt.executeUpdate();
            // update id
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                summary.setId(keys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return summary;
    }

    /**
     * membuat list yang berisi objek dari Summary.
     * ambil semua kolom dari database lalu konversi dari
     * result set menjadi objek Summary, lakukan sampai
     * semua baris diambil.
     *
     * @return List list atau ArrayList
     */
    @Override
    public List<Summary> findAll() {
        // menyimpan hasil kueri
        List<Summary> summaries = new ArrayList<>();

        String sql = "SELECT * FROM summaries";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                summaries.add(mapResultSetToSummary(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return summaries;
    }

    /**
     * mencari data berdasarkan id.
     *
     *
     * @param id
     * @return Optional
     */
    @Override
    public Optional<Summary> findById(Integer id) {
        String sql = "SELECT * FROM summaries WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapResultSetToSummary(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * untuk mengkonversi hasil dari resultset ke Summary POJO
     *
     * @param rs result set
     * @return Summary
     * @throws SQLException
     */
    private Summary mapResultSetToSummary(ResultSet rs) throws SQLException {
        return new Summary(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("original_text"),
                rs.getString("summary_text"),
                rs.getString("method"),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
