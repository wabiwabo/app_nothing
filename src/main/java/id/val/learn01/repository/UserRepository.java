package id.val.learn01.repository;

import id.val.learn01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface repository untuk entitas User.
 * 
 * PENJELASAN DETAIL:
 * 1. Fungsi Interface:
 *    - Menyediakan akses ke data User dalam database
 *    - Mengabstraksi operasi database
 *    - Menyediakan method CRUD dasar
 * 
 * 2. Pola Desain yang Digunakan:
 *    - Repository Pattern:
 *      * Mengabstraksi layer persistensi data
 *      * Memisahkan logika akses data dari logika bisnis
 *      * Menyediakan interface yang bersih untuk operasi data
 * 
 *    - Data Access Object (DAO) Pattern:
 *      * Menyediakan interface abstrak ke database
 *      * Mengenkapsulasi logika akses data
 *      * Memudahkan penggantian implementasi database
 * 
 * 3. Cara Kerja:
 *    - Spring Data JPA secara otomatis:
 *      * Mengimplementasikan interface ini saat runtime
 *      * Menyediakan implementasi untuk operasi CRUD standar
 *      * Menangani koneksi database
 * 
 * 4. Method yang Tersedia (Otomatis):
 *    - save(): Menyimpan atau memperbarui entitas
 *    - findById(): Mencari entitas berdasarkan ID
 *    - findAll(): Mengambil semua entitas
 *    - delete(): Menghapus entitas
 *    - count(): Menghitung jumlah entitas
 * 
 * 5. Best Practices:
 *    - Gunakan nama method yang sesuai konvensi Spring Data
 *    - Hindari logika bisnis dalam repository
 *    - Fokus pada operasi data murni
 */
public interface UserRepository extends JpaRepository<User, Long> {
} 