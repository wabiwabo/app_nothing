package id.val.learn01.service;

import id.val.learn01.exception.ResourceNotFoundException;
import id.val.learn01.model.User;
import id.val.learn01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Kelas service untuk entitas User yang mengimplementasikan logika bisnis.
 * 
 * PENJELASAN DETAIL:
 * 1. Fungsi Kelas:
 *    - Mengimplementasikan logika bisnis aplikasi
 *    - Menjadi perantara antara controller dan repository
 *    - Menangani validasi dan aturan bisnis
 *    - Mengimplementasikan caching untuk optimasi performa
 * 
 * 2. Pola Desain yang Digunakan:
 *    - Service Layer Pattern:
 *      * Memisahkan logika bisnis dari layer lainnya
 *      * Menyediakan interface yang bersih untuk controller
 *      * Memudahkan pengujian unit
 * 
 *    - Dependency Injection Pattern:
 *      * Menginjeksi UserRepository ke dalam service
 *      * Mengurangi coupling antar komponen
 *      * Memudahkan pengujian dengan mock objects
 * 
 *    - Facade Pattern:
 *      * Menyediakan interface yang disederhanakan
 *      * Menyembunyikan kompleksitas sistem
 *      * Memudahkan penggunaan sistem
 * 
 *    - Caching Pattern:
 *      * Menggunakan @Cacheable untuk menyimpan hasil query
 *      * Menggunakan @CacheEvict untuk menghapus cache
 *      * Meningkatkan performa aplikasi
 * 
 * 3. Method-method dalam Kelas:
 *    - getAllUsers(): Mengambil semua data pengguna (cached)
 *    - getUserById(): Mencari pengguna berdasarkan ID (cached)
 *    - createUser(): Membuat pengguna baru (evicts cache)
 *    - updateUser(): Memperbarui data pengguna (evicts cache)
 *    - deleteUser(): Menghapus pengguna (evicts cache)
 * 
 * 4. Penanganan Error:
 *    - Menggunakan ResourceNotFoundException untuk data tidak ditemukan
 *    - Memberikan pesan error yang informatif
 *    - Memudahkan debugging
 * 
 * 5. Best Practices:
 *    - Satu method untuk satu operasi bisnis
 *    - Validasi input sebelum operasi database
 *    - Logging untuk operasi penting
 *    - Penanganan error yang konsisten
 *    - Implementasi caching yang tepat
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    /**
     * Mengambil semua data pengguna dari database
     * @return List berisi semua data pengguna
     */
    @Cacheable(value = "users")
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("Tidak ada data pengguna yang tersedia");
        }
        return users;
    }
    
    /**
     * Mencari pengguna berdasarkan ID
     * @param id ID pengguna yang dicari
     * @return data pengguna jika ditemukan
     * @throws ResourceNotFoundException jika pengguna tidak ditemukan
     */
    @Cacheable(value = "userById", key = "#id")
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
    
    /**
     * Membuat pengguna baru dalam database
     * @param user data pengguna yang akan dibuat
     * @return data pengguna yang telah dibuat (dengan ID)
     * @throws IllegalArgumentException jika data pengguna tidak valid
     */
    @CacheEvict(value = {"users", "userById"}, allEntries = true)
    public User createUser(User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nama pengguna tidak boleh kosong");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email pengguna tidak boleh kosong");
        }
        return userRepository.save(user);
    }
    
    /**
     * Memperbarui data pengguna yang sudah ada
     * @param id ID pengguna yang akan diperbarui
     * @param userDetails data baru untuk pengguna
     * @return data pengguna yang telah diperbarui
     * @throws ResourceNotFoundException jika pengguna tidak ditemukan
     * @throws IllegalArgumentException jika data pengguna tidak valid
     */
    @CacheEvict(value = {"users", "userById"}, allEntries = true)
    public User updateUser(Long id, User userDetails) {
        // Validasi input
        if (userDetails.getName() == null || userDetails.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nama pengguna tidak boleh kosong");
        }
        if (userDetails.getEmail() == null || userDetails.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email pengguna tidak boleh kosong");
        }

        // Cari user yang akan diupdate
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        
        // Update data
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        
        return userRepository.save(user);
    }
    
    /**
     * Menghapus pengguna dari database
     * @param id ID pengguna yang akan dihapus
     * @throws ResourceNotFoundException jika pengguna tidak ditemukan
     */
    @CacheEvict(value = {"users", "userById"}, allEntries = true)
    public void deleteUser(Long id) {
        // Cek apakah user exists
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User", "id", id);
        }
        userRepository.deleteById(id);
    }
} 