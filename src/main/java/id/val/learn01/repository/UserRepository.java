package id.val.learn01.repository;

import id.val.learn01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for User entity.
 * 
 * DETAILED EXPLANATION:
 * 1. Interface Function:
 *    - Provides data access operations
 *    - Extends JpaRepository for CRUD operations
 *    - Manages database interactions
 *    - Implements data persistence
 * 
 * 2. Design Patterns Used:
 *    - Repository Pattern:
 *      * Abstracts data access layer
 *      * Provides collection-like interface
 *      * Encapsulates data access logic
 * 
 *    - Data Access Object (DAO):
 *      * Separates data access from business logic
 *      * Provides data persistence operations
 *      * Manages database connections
 * 
 * 3. Interface Methods:
 *    - Inherited from JpaRepository:
 *      * save(): Persists entity
 *      * findById(): Retrieves by ID
 *      * findAll(): Retrieves all
 *      * deleteById(): Removes entity
 *      * existsById(): Checks existence
 * 
 * 4. Best Practices:
 *    - Interface-based design
 *    - Spring Data JPA usage
 *    - Proper method naming
 *    - Type safety
 *    - Clean architecture
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
} 