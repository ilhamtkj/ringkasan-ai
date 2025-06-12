package com.ilham.mygui.ringkasanai.service.mapper;

import com.ilham.mygui.ringkasanai.model.Summary;
import com.ilham.mygui.ringkasanai.model.SummaryModel;

public class SummaryMapper {
    public static SummaryModel toModel(Summary pojo) {
        SummaryModel model = new SummaryModel();
        model.setId(pojo.getId());
        model.setTitle(pojo.getTitle());
        model.setOriginalText(pojo.getOriginalText());
        model.setSummaryText(pojo.getSummaryText());
        model.setMethod(pojo.getMethod());
        model.setcreatedAt(pojo.getCreatedAt());

        return model;
    }

    public static Summary toPojo(SummaryModel model) {
        Summary pojo = new Summary();
        pojo.setId(model.getId());
        pojo.setTitle(model.getTitle());
        pojo.setOriginalText(model.getOriginalText());
        pojo.setSummaryText(model.getSummaryText());
        pojo.setMethod(model.getMethod());
        pojo.setCreatedAt(model.getcreatedAt());

        return pojo;
    }
}
