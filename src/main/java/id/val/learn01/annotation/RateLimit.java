package id.val.learn01.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for rate limiting implementation.
 * 
 * DETAILED EXPLANATION:
 * 1. Annotation Function:
 *    - Implements rate limiting
 *    - Controls request frequency
 *    - Prevents API abuse
 *    - Manages server load
 * 
 * 2. Design Patterns Used:
 *    - Rate Limiting Pattern:
 *      * Controls request rate
 *      * Prevents system overload
 *      * Ensures fair usage
 * 
 * 3. Configuration Options:
 *    - limit: Maximum requests allowed
 *    - duration: Time window in seconds
 * 
 * 4. Usage:
 *    - Applied to controller methods
 *    - Configurable per endpoint
 *    - Runtime enforcement
 * 
 * 5. Best Practices:
 *    - Reasonable rate limits
 *    - Clear documentation
 *    - Proper error handling
 *    - Monitoring support
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {
    int limit() default 100;
    int duration() default 60; // in seconds
}