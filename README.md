# Learn01 - Spring Boot Application

Aplikasi Spring Boot yang mengimplementasikan CRUD operations dengan MySQL database dan berbagai fitur modern seperti caching, circuit breaker, dan rate limiting.

## Fitur Utama

- **CRUD Operations**: Implementasi lengkap Create, Read, Update, Delete untuk entitas User
- **Caching**: Implementasi caching menggunakan Spring Cache untuk optimasi performa
- **Error Handling**: Penanganan error yang komprehensif dengan custom exceptions
- **Environment Variables**: Konfigurasi menggunakan environment variables untuk keamanan
- **Rate Limiting**: Pembatasan request untuk mencegah abuse
- **Circuit Breaker**: Implementasi circuit breaker untuk meningkatkan resilience

## Teknologi yang Digunakan

- Java 17
- Spring Boot 3.2.3
- MySQL Database
- Spring Data JPA
- Spring Cache
- Resilience4j
- Bucket4j
- Lombok

## Struktur Proyek

```
src/main/java/id/val/learn01/
├── config/          # Konfigurasi aplikasi
├── controller/      # REST controllers
├── model/          # Entity classes
├── repository/     # Data access layer
├── service/        # Business logic
├── exception/      # Custom exceptions
├── annotation/     # Custom annotations
└── aspect/         # AOP aspects
```

## Cara Menjalankan Aplikasi

1. Clone repository:
   ```bash
   git clone [repository-url]
   cd learn01
   ```

2. Buat file `.env` dari template `.env.example`:
   ```bash
   cp .env.example .env
   ```

3. Sesuaikan konfigurasi di file `.env`:
   ```properties
   DB_HOST=localhost
   DB_PORT=3306
   DB_NAME=learn01
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   SERVER_PORT=8080
   ```

4. Jalankan aplikasi:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Endpoints

### User Management

- `GET /api/users` - Mendapatkan semua user
- `GET /api/users/{id}` - Mendapatkan user berdasarkan ID
- `POST /api/users` - Membuat user baru
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Hapus user

## Caching

Aplikasi menggunakan Spring Cache dengan dua cache utama:
- `users`: Cache untuk daftar semua user
- `userById`: Cache untuk user individual berdasarkan ID

## Error Handling

Aplikasi menggunakan custom exceptions:
- `ResourceNotFoundException`: Ketika resource tidak ditemukan
- `IllegalArgumentException`: Ketika input tidak valid

## Rate Limiting

Rate limiting diimplementasikan menggunakan Bucket4j dengan konfigurasi default:
- 100 request per 60 detik

## Circuit Breaker

Circuit breaker diimplementasikan menggunakan Resilience4j untuk meningkatkan resilience aplikasi.

## Contributing

1. Fork repository
2. Buat branch fitur baru (`git checkout -b feature/amazing-feature`)
3. Commit perubahan (`git commit -m 'Add some amazing feature'`)
4. Push ke branch (`git push origin feature/amazing-feature`)
5. Buat Pull Request

## License

Proyek ini dilisensikan di bawah MIT License - lihat file [LICENSE](LICENSE) untuk detail.

