package id.val.learn01.exception;

import java.time.LocalDateTime;

/**
 * Kelas untuk menstandarisasi format response error.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Menyediakan format yang konsisten untuk response error
 *    - Memudahkan client memahami error yang terjadi
 *    - Memudahkan debugging dengan informasi yang lengkap
 * 
 * 2. Field yang Tersedia:
 *    - timestamp: Waktu terjadinya error
 *    - status: Status HTTP
 *    - error: Jenis error
 *    - message: Pesan error
 *    - path: Path request yang menyebabkan error
 */
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(int status, String error, String message, String path) {
        this();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getters and Setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
} 