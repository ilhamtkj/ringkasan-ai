package com.ilham.mygui.ringkasanai.service.summarizer;

import com.ilham.mygui.ringkasanai.service.formatter.PromtFormatter;
import org.junit.jupiter.api.Test;

public class ApiBasedSummarizerTest {

    @Test
    public void testSummarize() {
        Summarizer summerizer = new ApiBasedSummarizer();

        String teks1 = "Linked list adalah strukur data linier berbentuk rantai simpul di mana setiap simpul menyimpan 2 item, yaitu nilai data dan pointer ke simpul elemen berikutnya. Berbeda dengan array, elemen linked list tidak ditempatkan dalam alamat memori yang berdekatan melainkan elemen ditautkan menggunakan pointer. Simpul pertama dari linked list disebut sebagai head atau simpul kepala. Apabila linked list berisi elemen kosong, maka nilai pointer dari head menunjuk ke NULL. Begitu juga untuk pointer berikutnya dari simpul terakhir atau simpul ekor akan menunjuk ke NULL. Ukuran elemen dari linked list dapat bertambah secara dinamis dan mudah untuk menyisipkan dan menghapus elemen karena tidak seperti array, kita hanya perlu mengubah pointer elemen sebelumnya dan elemen berikutnya untuk menyisipkan atau menghapus elemen.";
        String teks2 = "Buat ringkasan dari teks dibawah ini. ringkas sedikit mungkin. Teks: " + teks1;

        String finalPrompt = PromtFormatter.format(teks1, "ringkas sedikit mungkin");

        System.out.println(finalPrompt);
        String result = summerizer.summarize(finalPrompt);
        System.out.println(result);
    }
}
