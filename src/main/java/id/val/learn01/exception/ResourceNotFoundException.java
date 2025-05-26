package id.val.learn01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for resource not found scenarios.
 * 
 * DETAILED EXPLANATION:
 * 1. Class Function:
 *    - Handles resource not found errors
 *    - Provides detailed error messages
 *    - Maps to HTTP 404 status
 *    - Supports error tracking
 * 
 * 2. Design Patterns Used:
 *    - Exception Handling Pattern:
 *      * Custom exception for specific scenarios
 *      * Consistent error handling
 *      * Clear error messages
 * 
 * 3. Class Features:
 *    - Extends RuntimeException
 *    - Maps to HTTP 404
 *    - Supports resource details
 *    - Provides formatted messages
 * 
 * 4. Usage Examples:
 *    - When user not found: new ResourceNotFoundException("User", "id", 1)
 *    - When data not found: new ResourceNotFoundException("No data available")
 * 
 * 5. Best Practices:
 *    - Clear error messages
 *    - Proper HTTP status
 *    - Resource identification
 *    - Exception chaining
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    /**
     * Creates exception with resource details
     * @param resourceName type of resource
     * @param fieldName field used for search
     * @param fieldValue value used for search
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
    
    /**
     * Creates exception with custom message
     * @param message error message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
} 