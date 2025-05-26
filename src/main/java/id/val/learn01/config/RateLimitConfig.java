package id.val.learn01.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * Konfigurasi untuk rate limiting.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Membatasi jumlah request per waktu
 *    - Mencegah abuse API
 *    - Mengatur beban server
 */
@Configuration
public class RateLimitConfig {
    
    @Bean
    public Bucket createNewBucket() {
        Bandwidth limit = Bandwidth.simple(100, Duration.ofMinutes(1));
        return Bucket4j.builder()
                .addLimit(limit)
                .build();
    }
} 