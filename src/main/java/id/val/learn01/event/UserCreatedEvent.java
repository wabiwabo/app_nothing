package id.val.learn01.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Event yang dipublish ketika user baru dibuat.
 * 
 * PENJELASAN:
 * 1. Fungsi:
 *    - Menyimpan informasi event user created
 *    - Memungkinkan decoupling antar komponen
 *    - Memudahkan tracking perubahan
 */
@Getter
public class UserCreatedEvent extends ApplicationEvent {
    private final Long userId;
    private final String name;
    private final String email;
    
    public UserCreatedEvent(Object source, Long userId, String name, String email) {
        super(source);
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
} 