package id.val.learn01.controller;

import id.val.learn01.model.User;
import id.val.learn01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST untuk menangani request HTTP terkait User.
 * 
 * PENJELASAN DETAIL:
 * 1. Fungsi Kelas:
 *    - Menangani request HTTP dari client
 *    - Mengimplementasikan endpoint REST API
 *    - Mengkonversi antara format HTTP dan objek domain
 * 
 * 2. Pola Desain yang Digunakan:
 *    - MVC Pattern (Model-View-Controller):
 *      * Controller: Menangani request dan response
 *      * Model: Menyimpan data (User)
 *      * View: JSON response (tidak ada view terpisah)
 * 
 *    - REST Controller Pattern:
 *      * Menggunakan anotasi @RestController
 *      * Menangani HTTP method (GET, POST, PUT, DELETE)
 *      * Mengembalikan response dalam format JSON
 * 
 *    - Dependency Injection Pattern:
 *      * Menginjeksi UserService ke dalam controller
 *      * Mengurangi coupling antar komponen
 * 
 * 3. Endpoint yang Tersedia:
 *    - GET /api/users: Mengambil semua pengguna
 *    - GET /api/users/{id}: Mengambil pengguna berdasarkan ID
 *    - POST /api/users: Membuat pengguna baru
 *    - PUT /api/users/{id}: Memperbarui pengguna
 *    - DELETE /api/users/{id}: Menghapus pengguna
 * 
 * 4. Penanganan Response:
 *    - ResponseEntity: Membungkus response HTTP
 *    - Status code yang sesuai (200, 201, 404)
 *    - Response body dalam format JSON
 * 
 * 5. Best Practices:
 *    - Satu endpoint untuk satu operasi
 *    - Validasi input request
 *    - Penanganan error yang konsisten
 *    - Dokumentasi API yang jelas
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
     * Endpoint GET untuk mengambil semua data pengguna
     * @return List berisi semua data pengguna
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    /**
     * Endpoint GET untuk mengambil data pengguna berdasarkan ID
     * @param id ID pengguna yang dicari
     * @return ResponseEntity berisi data pengguna jika ditemukan
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    
    /**
     * Endpoint POST untuk membuat pengguna baru
     * @param user data pengguna yang akan dibuat
     * @return data pengguna yang telah dibuat
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
    
    /**
     * Endpoint PUT untuk memperbarui data pengguna
     * @param id ID pengguna yang akan diperbarui
     * @param userDetails data baru untuk pengguna
     * @return ResponseEntity berisi data pengguna yang diperbarui
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }
    
    /**
     * Endpoint DELETE untuk menghapus pengguna
     * @param id ID pengguna yang akan dihapus
     * @return ResponseEntity dengan status 200 OK jika berhasil
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
} 