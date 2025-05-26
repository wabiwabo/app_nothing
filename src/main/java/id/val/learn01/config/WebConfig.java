package id.val.learn01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Konfigurasi untuk menangani resource static dan request khusus.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Menangani request untuk resource static
 *    - Mengkonfigurasi handler untuk request khusus
 *    - Menangani request dari Chrome DevTools
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Menangani request Chrome DevTools
        registry.addResourceHandler("/.well-known/appspecific/com.chrome.devtools.json")
                .addResourceLocations("classpath:/static/.well-known/appspecific/");
    }
} 