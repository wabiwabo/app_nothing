package id.val.learn01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Main application class for the Spring Boot application.
 * 
 * DETAILED EXPLANATION:
 * 1. Class Function:
 *    - Application entry point
 *    - Bootstraps Spring context
 *    - Enables auto-configuration
 *    - Initializes components
 * 
 * 2. Features Enabled:
 *    - Spring Boot auto-configuration
 *    - Component scanning
 *    - Caching support
 *    - Web application support
 * 
 * 3. Configuration:
 *    - Component scanning
 *    - Auto-configuration
 *    - Property loading
 *    - Environment setup
 * 
 * 4. Best Practices:
 *    - Clean architecture
 *    - Proper configuration
 *    - Feature enabling
 *    - Documentation
 */
@SpringBootApplication
@EnableCaching
public class Learn01Application {
    
    /**
     * Main method to start the application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Learn01Application.class, args);
    }
} 