/**
 * 
 */
package com.pxil.pvt.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

/**
 * @author sanjeevkumar 
 * 18-Dec-2023 
 * 11:30:35 pm 
 * Objective :
 */
public class ExamplePayLoad {

	@NotBlank(message = "Name is mandatory")
	@Length(min = 5, max = 50, message = "Product name must be between 5-512 characters")
	private String name;

	@NotBlank(message = "Email is mandatory")
	private String email;

	@Min(value = 10, message = "Product price must be greater or equal to 10")
	@Max(value = 9999, message = "Product prices must be less than or equal to 9999")
	private float price;
	
	@NotEmpty( message = "user name should not be null or empty")
	@Size(min = 2, message = "user name should have at least 2 characters")
	private String fname;		
	
	@NotEmpty(message = "email should not be null or empty")
	@Email(message = "email should be a valid email format" )
	private String email2;
	
	@NotEmpty(message = "password should not be null or empty")
	@Size(min = 8, message = "password should have at least 8 characters")
	private String password;
	
	@NotBlank(message = "First name is required")
	@Size(min = 3, max = 20, message = "First name should be between 3 and 20 characters")
	String firstName;

	@NotBlank(message = "Last name is required")
	@Size(min = 3, max = 20, message = "Last name should be between 3 and 20 characters")
	String lastName;

	@NotBlank(message = "Email is required")
	@Email(message = "Email is invalid")
	String email3;
	

}// End of ExamplePayLoad



/**############################################################
 * ################# Jakarta-Validator ########################
 * ############################################################
 * 
 * AssertFalse: The annotated element must be false (use for boolean and Boolean types).
 *  
 * AssertTrue: The annotated element must be true. Supported types same as AssertFalse. 
 * 
 * DecimalMax: The annotated element must be a number whose value must be lower or equal to the specified maximum. Supported types are:
 * 
 * BigDecimal, BigInteger, CharSequence, byte, short, int, long, and their respective wrappers. 
 * 
 * DecimalMin: The annotated element must be a number whose value must be higher or equal to the specified minimum. Supported types same as DecimalMax. 
 * 
 * Digits: The annotated element must be a number within accepted range. Supported types same as DecimalMax. 
 * 
 * Email: The annotated element must be a well-formed email address. Supported types are CharSequence. 
 * 
 * Future: The annotated element must be a date in the future. Supported types are java.util.Date and java.util.Calendar.
 *  
 * Max: The annotated element must be a number whose value must be lower or equal to the specified maximum. Supported types same as DecimalMax. 
 * 
 * Min: The annotated element must be a number whose value must be higher or equal to the specified minimum. Supported types same as DecimalMax. 
 * 
 * NotBlank: The annotated element must not be null and must contain at least one non-whitespace character. Supported types are CharSequence. 
 * 
 * NotEmpty: The annotated element must not be null nor empty. Supported types are: CharSequence, Collection, Map, Array. NotNull: The annotated element must 
 * not be null. Accepts any type.
 * 
 * Null: The annotated element must be null. Accepts any type. 
 * 
 * Past: The annotated element must be a date in the past. Supported types same as Future. 
 * 
 * Pattern: The annotated CharSequence must match the specified regular expression. Size: The annotated element size must be between the specified 
 * boundaries (included). Supported types are: CharSequence, Collection, Map, Array.
 * 
 * #############################################################
 * ########### Hibernate-Validator #############################
 * #############################################################
 * 
 * CreditCardNumber: The annotated element has to represent a valid credit card number.
 * 
 * ISBN: Checks that the annotated character sequence is a valid ISBN.
 * 
 * Length: Validates that the string is between min and max included.
 * 
 * Range: The annotated element has to be in the appropriate range. Apply on numeric values or string representation of the numeric value.
 * 
 * URL: Validates the annotated string is an URL
 * 
 */
