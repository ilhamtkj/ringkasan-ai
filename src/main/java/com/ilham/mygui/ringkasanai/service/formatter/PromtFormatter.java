package com.ilham.mygui.ringkasanai.service.formatter;

public class PromtFormatter {

    /**
     * untuk membuat promt yang siap dikirim ke ai.
     * method ini akan membuat promt yang menggabungkan
     * perintah untuk meringkas, perintah tambahan dari
     * pengguna dan juga teks yang ingin diringkas.
     *
     * @param text String original teks yang belum diringkas
     * @param options String opsi tambahan/perintah tambahan
     * @return String teks yang sudah siap dikirim ke ai
     */
    public static String format(String text, String options) {
        return String.format("""
                Buat ringkasan dari teks dibawah ini. %s.
                Teks:
                %s
                """, options, text);
    }
}
