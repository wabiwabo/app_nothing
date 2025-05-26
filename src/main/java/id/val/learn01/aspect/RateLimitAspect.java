package id.val.learn01.aspect;

import id.val.learn01.annotation.RateLimit;
import io.github.bucket4j.Bucket;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

/**
 * Aspect untuk menangani rate limiting.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Menangani annotation @RateLimit
 *    - Membatasi jumlah request
 *    - Mengembalikan error jika limit terlampaui
 */
@Aspect
@Component
public class RateLimitAspect {
    
    @Autowired
    private Bucket bucket;
    
    @Around("@annotation(rateLimit)")
    public Object rateLimit(ProceedingJoinPoint joinPoint, RateLimit rateLimit) throws Throwable {
        if (bucket.tryConsume(1)) {
            return joinPoint.proceed();
        } else {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Rate limit exceeded");
        }
    }
} 