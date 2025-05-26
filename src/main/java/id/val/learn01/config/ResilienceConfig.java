package id.val.learn01.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * Konfigurasi untuk resilience patterns.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Mengkonfigurasi circuit breaker
 *    - Menangani kegagalan service
 *    - Meningkatkan reliability aplikasi
 */
@Configuration
public class ResilienceConfig {
    
    @Bean
    public CircuitBreakerRegistry circuitBreakerRegistry() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(60))
                .permittedNumberOfCallsInHalfOpenState(2)
                .slidingWindowSize(2)
                .build();
        
        return CircuitBreakerRegistry.of(config);
    }
} 