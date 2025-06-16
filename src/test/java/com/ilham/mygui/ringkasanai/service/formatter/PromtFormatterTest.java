package com.ilham.mygui.ringkasanai.service.formatter;

import javafx.fxml.FXML;
import org.junit.jupiter.api.Test;

import java.util.Formatter;

public class PromtFormatterTest {

    @Test
    public void testFormat() {
        String text = """
                Jagal (bahasa Inggris: The Act of Killing) adalah film dokumenter karya sutradara Amerika Serikat Joshua Oppenheimer.[4] Dokumenter ini menyorot bagaimana pelaku pembunuhan anti-PKI yang terjadi pada tahun 1965–1966 memproyeksikan dirinya ke dalam sejarah untuk menjustifikasi kekejamannya sebagai perbuatan heroik.
                
                Film ini adalah hasil kerja sama Denmark-Britania Raya-Norwegia yang dipersembahkan oleh Final Cut for Real di Denmark, diproduseri Signe Byrge Sørensen, diko-sutradarai Anonim dan Christine Cynn, dan diproduseri eksekutif oleh Werner Herzog, Errol Morris, Joram ten Brink, dan André Singer. Ini adalah proyek Docwest dari Universitas Westminster.""";
        String options = "ringkas sesingkat singkatnya dan terjemahkan ke bahasa inggris";
        PromtFormatter formatter = new PromtFormatter();
        String result = formatter.format(text, options);
        System.out.println(result);
    }
}
