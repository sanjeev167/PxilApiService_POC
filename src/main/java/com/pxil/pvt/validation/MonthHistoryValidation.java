/**
 * 
 */
package com.pxil.pvt.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * @author sanjeevkumar 
 * 17-Dec-2023 
 * 1:47:19 am 
 * Objective :
 */
@Target({ ElementType.FIELD,ElementType.PARAMETER }) 
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {MonthHistoryValidator.class})
public @interface MonthHistoryValidation {

	//error message
    public String message() default "Invalid History-Month-Value - Should be a Month-No among last 4-Months.";
     
    public int historyMonth() default 1;
    //represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    /**
     * @return
     */
    public Class<? extends Payload>[] payload() default {};
    
}//End of MonthHistoryValidation
