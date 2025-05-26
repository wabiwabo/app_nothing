package id.val.learn01.query;

import lombok.Data;

/**
 * Query untuk mengambil data user.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Menyimpan parameter untuk query user
 *    - Memisahkan logika command dan query
 *    - Mengoptimalkan operasi read
 */
@Data
public class UserQuery {
    private Long id;
    private String name;
    private String email;
    private Integer page = 0;
    private Integer size = 10;
    private String sortBy = "id";
    private String sortDirection = "ASC";
} 