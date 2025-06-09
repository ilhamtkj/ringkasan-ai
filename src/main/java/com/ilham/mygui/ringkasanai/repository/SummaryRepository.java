package com.ilham.mygui.ringkasanai.repository;

import com.ilham.mygui.ringkasanai.model.Summary;

import java.util.List;
import java.util.Optional;

public interface SummaryRepository {
    Summary save(Summary summary);
    List<Summary> findAll();
    Optional<Summary> findById(Integer id);

    // nanti
    // List<Summary> findByTitle(String title);
    // void delete(Summary summary);
    // void deleteById(Integer id);

}
