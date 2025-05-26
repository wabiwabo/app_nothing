package id.val.learn01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception yang dilempar ketika resource (seperti User) tidak ditemukan.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Menandai bahwa resource yang dicari tidak ada
 *    - Memberikan pesan error yang informatif
 *    - Mengembalikan status HTTP 404 (NOT_FOUND)
 * 
 * 2. Penggunaan:
 *    - Digunakan di service layer
 *    - Ditangkap oleh global exception handler
 *    - Dikonversi ke response HTTP yang sesuai
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s tidak ditemukan dengan %s : '%s'", resourceName, fieldName, fieldValue));
    }
} 