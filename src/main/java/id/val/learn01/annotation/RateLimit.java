package id.val.learn01.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation untuk rate limiting.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Membatasi jumlah request per waktu
 *    - Mencegah abuse API
 *    - Mengatur beban server
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {
    int limit() default 100;
    int duration() default 60; // dalam detik
} 