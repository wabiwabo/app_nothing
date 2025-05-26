package id.val.learn01.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Command untuk membuat user baru.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Menyimpan data untuk operasi create user
 *    - Validasi input sebelum diproses
 *    - Memisahkan logika command dan query
 */
@Data
public class CreateUserCommand {
    @NotBlank(message = "Nama tidak boleh kosong")
    private String name;
    
    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format email tidak valid")
    private String email;
} 