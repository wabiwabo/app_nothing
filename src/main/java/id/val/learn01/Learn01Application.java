package id.val.learn01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kelas utama aplikasi Spring Boot Learn01.
 * 
 * PENJELASAN DETAIL:
 * 1. Fungsi Kelas:
 *    - Merupakan titik masuk (entry point) aplikasi Spring Boot
 *    - Menginisialisasi dan menjalankan aplikasi Spring Boot
 *    - Mengaktifkan konfigurasi otomatis Spring Boot
 * 
 * 2. Anotasi @SpringBootApplication:
 *    - Merupakan anotasi gabungan yang terdiri dari:
 *      * @Configuration: Menandai kelas sebagai sumber definisi bean Spring
 *      * @EnableAutoConfiguration: Mengaktifkan konfigurasi otomatis Spring Boot
 *      * @ComponentScan: Memerintahkan Spring untuk mencari komponen lain
 * 
 * 3. Cara Kerja:
 *    - Saat aplikasi dijalankan, Spring Boot akan:
 *      * Memindai semua komponen dalam package
 *      * Mengkonfigurasi aplikasi secara otomatis
 *      * Menjalankan server web embedded
 * 
 * 4. Best Practices:
 *    - Selalu letakkan kelas ini di root package
 *    - Gunakan package yang sesuai dengan struktur aplikasi
 *    - Pastikan semua komponen berada dalam package yang sama atau sub-package
 */
@SpringBootApplication
public class Learn01Application {
    public static void main(String[] args) {
        SpringApplication.run(Learn01Application.class, args);
    }
} 