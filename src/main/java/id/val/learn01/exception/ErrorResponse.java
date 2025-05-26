package id.val.learn01.exception;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Standard error response structure.
 * 
 * DETAILED EXPLANATION:
 * 1. Class Function:
 *    - Standardizes error response format
 *    - Provides error details
 *    - Supports error tracking
 *    - Facilitates debugging
 * 
 * 2. Design Patterns Used:
 *    - Data Transfer Object (DTO):
 *      * Transfers error information
 *      * Standardizes response format
 *      * Encapsulates error details
 * 
 * 3. Class Fields:
 *    - timestamp: When error occurred
 *    - message: Error description
 *    - details: Additional information
 * 
 * 4. Usage:
 *    - Returned by exception handlers
 *    - Consistent across all errors
 *    - Supports error tracking
 * 
 * 5. Best Practices:
 *    - Clear field naming
 *    - Lombok usage
 *    - Immutable design
 *    - Proper documentation
 */
@Data
@AllArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private String details;
} 