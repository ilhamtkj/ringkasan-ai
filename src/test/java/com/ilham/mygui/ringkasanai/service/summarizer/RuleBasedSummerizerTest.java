package com.ilham.mygui.ringkasanai.service.summarizer;

import com.ilham.mygui.ringkasanai.service.formatter.BinaryFormatter;
import com.ilham.mygui.ringkasanai.service.formatter.PreFormatter;
import org.junit.jupiter.api.Test;

public class RuleBasedSummerizerTest {

    @Test
    public void testRuleBasedSummarizer() {
        Summarizer ruleBased = new RuleBasedSummarizer();
        String text = "Di sebuah desa kecil yang dikelilingi hutan lebat, tinggal seorang anak laki-laki bernama Rafi. Ia tinggal bersama neneknya yang sudah tua, tetapi bijaksana. Setiap sore, nenek selalu bercerita tentang makhluk ajaib yang tinggal di hutan. Rafi sangat penasaran dan ingin melihatnya sendiri. Suatu pagi, ia membawa bekal dan masuk ke dalam hutan. Ia melewati sungai, pohon tinggi, dan semak berduri. Setelah berjalan lama, ia menemukan seekor rusa putih yang bisa bicara. Rusa itu memperkenalkan diri sebagai Rono, penjaga hutan. Rono berkata bahwa hanya anak berhati murni yang bisa melihatnya. Rafi terkejut, tapi merasa sangat senang. Rono mengajak Rafi ke bagian hutan yang belum pernah dilihat manusia. Di sana ada bunga-bunga yang menyala dan burung dengan bulu pelangi. Rafi merasa seperti berada di dunia mimpi. Mereka duduk di tepi danau yang jernih, dan Rono mulai bercerita tentang asal mula hutan ajaib. Konon, dulu ada seorang raja yang menanam benih pohon kebaikan. Dari benih itu tumbuhlah hutan yang hanya bisa dijaga oleh makhluk berhati bersih. Namun, sejak raja wafat, hanya sedikit manusia yang layak masuk ke sana. Rafi bertanya apakah ia boleh kembali ke sana suatu hari nanti. Rono tersenyum dan berkata, “Jika hatimu tetap tulus, pintu ini akan selalu terbuka.” Hari mulai gelap, dan Rafi pun diantar pulang oleh sekelompok kelinci bersinar. Saat tiba di rumah, nenek tersenyum seperti tahu apa yang telah terjadi. Keesokan harinya, Rafi menceritakan semuanya, tapi teman-temannya tidak percaya. Mereka pikir Rafi hanya mengarang cerita. Namun, setiap malam, Rafi bisa mendengar suara tawa lembut dari arah hutan. Ia tahu bahwa dunia ajaib itu memang nyata. Ia pun mulai merawat bunga, menolong orang lain, dan menjaga hewan. Hatinya semakin bersinar, dan hutan seolah memanggilnya kembali. Suatu hari, Rono muncul di tepi desa dan mengajak Rafi ikut lagi. Kali ini, ia dibawa ke pohon tertinggi di hutan. Di puncaknya, ada rumah dari cahaya. Di sana, para penjaga hutan sedang berkumpul. Mereka berkata bahwa Rafi terpilih menjadi penjaga berikutnya. Meski masih muda, ia punya keberanian dan kebaikan yang luar biasa. Nenek pun memberikan sebuah medali tua, tanda bahwa ia juga pernah ke sana dahulu. Rafi terkejut tapi bahagia, karena ia dan nenek ternyata punya takdir yang sama. Sejak hari itu, Rafi menjaga hutan bersama Rono dan para makhluk ajaib. Ia menanam pohon, menyembuhkan hewan, dan menjaga keseimbangan alam. Dunia manusia tidak tahu, tapi hutan tetap damai karena penjaga-penjaganya. Tahun demi tahun berlalu, dan legenda tentang anak penjaga hutan pun menyebar. Orang-orang mulai percaya dan datang membawa bunga sebagai tanda hormat. Rafi tetap muncul sesekali, menolong diam-diam. Ia tidak ingin terkenal, hanya ingin kebaikan terus tumbuh. Dan setiap malam, suara burung pelangi dan cahaya bunga tetap bersinar dari balik pohon. Dunia mungkin berubah, tapi hutan ajaib dan penjaganya akan selalu ada.";
        String oneSentence = "Linked list adalah strukur data linier berbentuk rantai simpul di mana setiap simpul menyimpan 2 item, yaitu nilai data dan pointer ke simpul elemen berikutnya.";

        PreFormatter formatter = new BinaryFormatter();
        String formattedText = formatter.format(text, "panjang");

        System.out.println(ruleBased.summarize(formattedText));

    }
}
