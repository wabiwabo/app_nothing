package id.val.learn01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Kelas entitas User yang merepresentasikan tabel user dalam database.
 * 
 * PENJELASAN DETAIL:
 * 1. Fungsi Kelas:
 *    - Menyimpan data pengguna
 *    - Memetakan kelas Java ke tabel database
 *    - Menyediakan struktur data untuk transfer data
 * 
 * 2. Pola Desain yang Digunakan:
 *    - Data Transfer Object (DTO) Pattern:
 *      * Memisahkan layer presentasi dari layer bisnis
 *      * Mengurangi jumlah panggilan method
 *      * Meningkatkan performa aplikasi
 * 
 *    - JPA Entity Pattern:
 *      * Memetakan kelas Java ke tabel database
 *      * Menangani operasi database secara otomatis
 *      * Menyediakan fitur ORM (Object-Relational Mapping)
 * 
 * 3. Anotasi yang Digunakan:
 *    - @Entity: 
 *      * Menandai kelas sebagai entitas JPA
 *      * Menunjukkan bahwa kelas ini akan dipetakan ke tabel database
 * 
 *    - @Data (Lombok):
 *      * Menghasilkan getter dan setter secara otomatis
 *      * Menghasilkan method toString()
 *      * Menghasilkan method equals() dan hashCode()
 *      * Mengurangi boilerplate code
 * 
 *    - @Id:
 *      * Menandai field sebagai primary key
 *      * Wajib ada dalam setiap entitas JPA
 * 
 *    - @GeneratedValue:
 *      * Mengatur cara generate nilai primary key
 *      * IDENTITY: Menggunakan auto-increment database
 * 
 * 4. Field-field dalam Kelas:
 *    - id: Primary key, auto-generated
 *    - name: Nama lengkap pengguna
 *    - email: Alamat email pengguna
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Nama lengkap pengguna
     * Digunakan untuk identifikasi pengguna
     */
    private String name;
    
    /**
     * Alamat email pengguna
     * Digunakan untuk komunikasi dan validasi
     */
    private String email;
} 