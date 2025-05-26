package id.val.learn01.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Konfigurasi untuk caching.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Mengkonfigurasi cache manager
 *    - Meningkatkan performa aplikasi
 *    - Mengurangi beban database
 */
@Configuration
@EnableCaching
public class CacheConfig {
    
    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setCacheNames(java.util.Arrays.asList("users", "userById"));
        return cacheManager;
    }
} 