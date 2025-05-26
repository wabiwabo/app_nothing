package id.val.learn01.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for caching implementation.
 * 
 * DETAILED EXPLANATION:
 * 1. Class Function:
 *    - Configures caching mechanism
 *    - Defines cache manager
 *    - Enables caching support
 *    - Optimizes application performance
 * 
 * 2. Design Patterns Used:
 *    - Configuration Pattern:
 *      * Centralizes cache configuration
 *      * Provides cache management
 *      * Enables caching features
 * 
 * 3. Cache Configuration:
 *    - users: Cache for user list
 *    - userById: Cache for individual users
 * 
 * 4. Features:
 *    - Concurrent cache support
 *    - Multiple cache regions
 *    - Automatic cache management
 * 
 * 5. Best Practices:
 *    - Clear cache naming
 *    - Proper cache configuration
 *    - Performance optimization
 *    - Thread safety
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