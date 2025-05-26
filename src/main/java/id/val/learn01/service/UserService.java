package id.val.learn01.service;

import id.val.learn01.exception.ResourceNotFoundException;
import id.val.learn01.model.User;
import id.val.learn01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for User entity implementing business logic.
 * 
 * DETAILED EXPLANATION:
 * 1. Class Function:
 *    - Implements application business logic
 *    - Acts as intermediary between controller and repository
 *    - Handles validation and business rules
 *    - Implements caching for performance optimization
 * 
 * 2. Design Patterns Used:
 *    - Service Layer Pattern:
 *      * Separates business logic from other layers
 *      * Provides clean interface for controller
 *      * Facilitates unit testing
 * 
 *    - Dependency Injection Pattern:
 *      * Injects UserRepository into service
 *      * Reduces component coupling
 *      * Enables testing with mock objects
 * 
 *    - Facade Pattern:
 *      * Provides simplified interface
 *      * Hides system complexity
 *      * Eases system usage
 * 
 *    - Caching Pattern:
 *      * Uses @Cacheable for query result storage
 *      * Uses @CacheEvict for cache invalidation
 *      * Improves application performance
 * 
 * 3. Class Methods:
 *    - getAllUsers(): Retrieves all users (cached)
 *    - getUserById(): Retrieves user by ID (cached)
 *    - createUser(): Creates new user (evicts cache)
 *    - updateUser(): Updates existing user (evicts cache)
 *    - deleteUser(): Deletes user (evicts cache)
 * 
 * 4. Error Handling:
 *    - Uses ResourceNotFoundException for not found scenarios
 *    - Provides informative error messages
 *    - Facilitates debugging
 * 
 * 5. Best Practices:
 *    - Single responsibility per method
 *    - Input validation before database operations
 *    - Logging for critical operations
 *    - Consistent error handling
 *    - Proper caching implementation
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    /**
     * Retrieves all users from the database
     * @return List containing all user data
     */
    @Cacheable(value = "users")
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No user data available");
        }
        return users;
    }
    
    /**
     * Retrieves user by ID
     * @param id ID of the user to retrieve
     * @return user data if found
     * @throws ResourceNotFoundException if user not found
     */
    @Cacheable(value = "userById", key = "#id")
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
    
    /**
     * Creates a new user in the database
     * @param user user data to create
     * @return created user data (with ID)
     * @throws IllegalArgumentException if user data is invalid
     */
    @CacheEvict(value = {"users", "userById"}, allEntries = true)
    public User createUser(User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("User email cannot be empty");
        }
        return userRepository.save(user);
    }
    
    /**
     * Updates an existing user's data
     * @param id ID of the user to update
     * @param userDetails new user data
     * @return updated user data
     * @throws ResourceNotFoundException if user not found
     * @throws IllegalArgumentException if user data is invalid
     */
    @CacheEvict(value = {"users", "userById"}, allEntries = true)
    public User updateUser(Long id, User userDetails) {
        // Input validation
        if (userDetails.getName() == null || userDetails.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (userDetails.getEmail() == null || userDetails.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("User email cannot be empty");
        }

        // Find user to update
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        
        // Update data
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        
        return userRepository.save(user);
    }
    
    /**
     * Deletes a user from the database
     * @param id ID of the user to delete
     * @throws ResourceNotFoundException if user not found
     */
    @CacheEvict(value = {"users", "userById"}, allEntries = true)
    public void deleteUser(Long id) {
        // Check if user exists
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User", "id", id);
        }
        userRepository.deleteById(id);
    }
} 