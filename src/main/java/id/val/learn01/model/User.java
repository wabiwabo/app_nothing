package id.val.learn01.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity class representing a User in the system.
 * 
 * DETAILED EXPLANATION:
 * 1. Class Function:
 *    - Represents user data structure
 *    - Maps to database table
 *    - Provides data validation
 *    - Implements JPA annotations
 * 
 * 2. Design Patterns Used:
 *    - Entity Pattern:
 *      * Maps to database table
 *      * Handles data persistence
 *      * Manages relationships
 * 
 *    - Data Transfer Object (DTO):
 *      * Transfers data between layers
 *      * Encapsulates user information
 *      * Provides data validation
 * 
 * 3. Class Fields:
 *    - id: Primary key
 *    - name: User's full name
 *    - email: User's email address
 * 
 * 4. Annotations Used:
 *    - @Entity: Marks as JPA entity
 *    - @Table: Specifies table name
 *    - @Id: Marks primary key
 *    - @GeneratedValue: Configures ID generation
 *    - @Column: Configures column properties
 *    - @Data: Lombok annotation for getters/setters
 * 
 * 5. Best Practices:
 *    - Clear field naming
 *    - Proper data types
 *    - Column constraints
 *    - Lombok usage
 *    - JPA annotations
 */
@Entity
@Table(name = "users")
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
} 