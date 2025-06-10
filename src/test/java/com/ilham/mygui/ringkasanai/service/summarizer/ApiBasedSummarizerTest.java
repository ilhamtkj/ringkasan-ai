package com.ilham.mygui.ringkasanai.service.summarizer;

import org.junit.jupiter.api.Test;

public class ApiBasedSummarizerTest {

    @Test
    public void testSummarize() {
        Summarizer summerizer = new ApiBasedSummerizer();

        String teks1 = "ringkaskan dan terjemahkan ke bahasa inggris teks ini: Linked list adalah strukur data linier berbentuk rantai simpul di mana setiap simpul menyimpan 2 item, yaitu nilai data dan pointer ke simpul elemen berikutnya. Berbeda dengan array, elemen linked list tidak ditempatkan dalam alamat memori yang berdekatan melainkan elemen ditautkan menggunakan pointer. Simpul pertama dari linked list disebut sebagai head atau simpul kepala. Apabila linked list berisi elemen kosong, maka nilai pointer dari head menunjuk ke NULL. Begitu juga untuk pointer berikutnya dari simpul terakhir atau simpul ekor akan menunjuk ke NULL. Ukuran elemen dari linked list dapat bertambah secara dinamis dan mudah untuk menyisipkan dan menghapus elemen karena tidak seperti array, kita hanya perlu mengubah pointer elemen sebelumnya dan elemen berikutnya untuk menyisipkan atau menghapus elemen.";
        String teks2 = "apa itu bahasa pemrograman java, jelaskan secara singkat";
        String result = summerizer.summarize(teks1);
        System.out.println(result);
    }
}
