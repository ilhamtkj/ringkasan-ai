# Ayo baca aku

saya mencoba menjalankan program ini di windows 11 dan fedora 42.  
dengan menggunakan:
- java 21
- mariadb Ver 15.1 Distrib 10.11.11-MariaDB, for Linux (x86_64) using EditLine wrapper  
- mariadb 11.4 (windows)
- ollama

## Cara menjalankan
### persiapan
1. install ollama dan model mistral 7b.
2. buat database seperti ini  supaya bisa menerima bermacam karakter.
``` mariadb
CREATE TABLE summaries
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(200) NOT NULL,
    original_text TEXT         NOT NULL,
    summary_text  TEXT         NOT NULL,
    method        VARCHAR(30)  NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```
buat database supaya menerima utf8mb4
```mariadb
ALTER DATABASE uas_pbo CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
```
ubah konfigurasi mariadb
```
[client]
default-character-set = utf8mb4

[mysqld]
character-set-server = utf8mb4
collation-server = utf8mb4_general_ci
```
3. sesuaikan file [koneksi database](src/main/java/com/ilham/mygui/ringkasanai/util/Database.java) atau buat user yang menyesuaikan file tersebut.

### menjalankan program
bisa jalankan langsung dengan
```shell
mvn clean javafx:run -Pdev
```
atau buat menjadi jar dengan
```shell
mvn clean package -DskipTests -Plinux
```
ubah linux dengan windows/mac untuk build ke sistem operasi yang berbeda.  
hasil .jar berada di target, jalankan file yang tidak ada kata original.