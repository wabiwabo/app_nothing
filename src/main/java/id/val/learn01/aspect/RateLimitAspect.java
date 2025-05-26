package id.val.learn01.aspect;

import id.val.learn01.annotation.RateLimit;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Aspect implementation for rate limiting functionality.
 * 
 * DETAILED EXPLANATION:
 * 1. Class Function:
 *    - Implements rate limiting logic
 *    - Manages request buckets
 *    - Enforces rate limits
 *    - Handles rate limit violations
 * 
 * 2. Design Patterns Used:
 *    - Aspect-Oriented Programming:
 *      * Cross-cutting concerns
 *      * Non-invasive implementation
 *      * Runtime enforcement
 * 
 *    - Bucket Token Algorithm:
 *      * Token-based rate limiting
 *      * Fair request distribution
 *      * Efficient resource usage
 * 
 * 3. Implementation Details:
 *    - Bucket management per method
 *    - Configurable rate limits
 *    - Thread-safe implementation
 *    - Automatic token refill
 * 
 * 4. Error Handling:
 *    - 429 Too Many Requests
 *    - Clear error messages
 *    - Proper exception handling
 * 
 * 5. Best Practices:
 *    - Thread safety
 *    - Efficient bucket management
 *    - Clear error messages
 *    - Proper logging
 */
@Aspect
@Component
public class RateLimitAspect {
    
    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();
    
    /**
     * Implements rate limiting around annotated methods
     * @param joinPoint the method being intercepted
     * @param rateLimit the rate limit annotation
     * @return the method result if rate limit not exceeded
     * @throws Throwable if rate limit exceeded or method fails
     */
    @Around("@annotation(rateLimit)")
    public Object rateLimit(ProceedingJoinPoint joinPoint, RateLimit rateLimit) throws Throwable {
        String key = joinPoint.getSignature().toLongString();
        Bucket bucket = buckets.computeIfAbsent(key, k -> createBucket(rateLimit));
        
        if (bucket.tryConsume(1)) {
            return joinPoint.proceed();
        } else {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Rate limit exceeded");
        }
    }
    
    /**
     * Creates a new rate limiting bucket
     * @param rateLimit the rate limit configuration
     * @return configured bucket for rate limiting
     */
    private Bucket createBucket(RateLimit rateLimit) {
        Refill refill = Refill.intervally(rateLimit.limit(), Duration.ofSeconds(rateLimit.duration()));
        Bandwidth limit = Bandwidth.classic(rateLimit.limit(), refill);
        return Bucket4j.builder().addLimit(limit).build();
    }
} 