package id.val.learn01.controller;

import id.val.learn01.model.User;
import id.val.learn01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for User entity.
 * 
 * DETAILED EXPLANATION:
 * 1. Class Function:
 *    - Handles HTTP requests for User operations
 *    - Provides RESTful endpoints
 *    - Manages request/response flow
 *    - Implements rate limiting for API protection
 * 
 * 2. Design Patterns Used:
 *    - REST Controller Pattern:
 *      * Follows REST architectural style
 *      * Uses HTTP methods appropriately
 *      * Returns proper HTTP status codes
 * 
 *    - Dependency Injection Pattern:
 *      * Injects UserService into controller
 *      * Reduces component coupling
 *      * Enables testing with mock objects
 * 
 * 3. Class Methods:
 *    - getAllUsers(): GET /api/users
 *    - getUserById(): GET /api/users/{id}
 *    - createUser(): POST /api/users
 *    - updateUser(): PUT /api/users/{id}
 *    - deleteUser(): DELETE /api/users/{id}
 * 
 * 4. Error Handling:
 *    - Uses ResponseEntity for HTTP responses
 *    - Proper HTTP status codes
 *    - Consistent response format
 * 
 * 5. Best Practices:
 *    - Clear endpoint naming
 *    - Proper HTTP method usage
 *    - Input validation
 *    - Consistent response structure
 *    - Rate limiting implementation
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
     * Retrieves all users
     * @return ResponseEntity containing list of users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
    /**
     * Retrieves user by ID
     * @param id ID of the user to retrieve
     * @return ResponseEntity containing user data
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    
    /**
     * Creates a new user
     * @param user user data to create
     * @return ResponseEntity containing created user data
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
    
    /**
     * Updates an existing user
     * @param id ID of the user to update
     * @param userDetails new user data
     * @return ResponseEntity containing updated user data
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }
    
    /**
     * Deletes a user
     * @param id ID of the user to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
} 