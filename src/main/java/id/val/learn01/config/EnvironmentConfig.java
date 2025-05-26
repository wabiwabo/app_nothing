package id.val.learn01.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Konfigurasi untuk mengelola environment variables.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Membaca environment variables dari file .env
 *    - Menyediakan akses ke environment variables
 *    - Memastikan keamanan kredensial
 * 
 * 2. Best Practices:
 *    - Kredensial tidak disimpan di kode
 *    - Mudah dikonfigurasi untuk environment berbeda
 *    - Aman untuk version control
 */
@Configuration
public class EnvironmentConfig {
    
    private static final Logger logger = LoggerFactory.getLogger(EnvironmentConfig.class);
    private static Dotenv dotenv;
    
    @Bean
    public Dotenv dotenv() {
        if (dotenv == null) {
            dotenv = Dotenv.configure()
                    .directory("./")
                    .ignoreIfMalformed()
                    .ignoreIfMissing()
                    .load();
            
            // Log environment variables (tanpa password)
            logger.info("Environment variables loaded:");
            logger.info("DB_HOST: {}", dotenv.get("DB_HOST"));
            logger.info("DB_PORT: {}", dotenv.get("DB_PORT"));
            logger.info("DB_NAME: {}", dotenv.get("DB_NAME"));
            logger.info("DB_USERNAME: {}", dotenv.get("DB_USERNAME"));
            logger.info("SERVER_PORT: {}", dotenv.get("SERVER_PORT"));
        }
        return dotenv;
    }
    
    /**
     * Mendapatkan nilai environment variable
     * @param key nama environment variable
     * @return nilai environment variable
     */
    public static String getEnv(String key) {
        return System.getenv(key) != null ? System.getenv(key) : getDotenv().get(key);
    }
    
    /**
     * Mendapatkan nilai environment variable dengan nilai default
     * @param key nama environment variable
     * @param defaultValue nilai default jika environment variable tidak ditemukan
     * @return nilai environment variable atau nilai default
     */
    public static String getEnv(String key, String defaultValue) {
        String value = getEnv(key);
        return value != null ? value : defaultValue;
    }
    
    /**
     * Mendapatkan instance Dotenv
     * @return instance Dotenv
     */
    private static Dotenv getDotenv() {
        if (dotenv == null) {
            dotenv = Dotenv.configure()
                    .directory("./")
                    .ignoreIfMalformed()
                    .ignoreIfMissing()
                    .load();
        }
        return dotenv;
    }
} 