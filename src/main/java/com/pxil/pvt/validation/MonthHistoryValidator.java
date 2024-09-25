/**
 * 
 */
package com.pxil.pvt.validation;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author sanjeevkumar 
 * 20-Dec-2023 
 * 7:39:17 am 
 * Objective :
 */
public class MonthHistoryValidator implements ConstraintValidator<MonthHistoryValidation, Integer> {

	@Value(value = "${pxil.api.validation.maxAllowedHistoryMonth}")
	private int maxAllowedHistoryMonth;

	public String message;
	public int historyMonth;

	public void initialize(MonthHistoryValidation requiredIfChecked) {
		this.historyMonth = requiredIfChecked.historyMonth();
		this.message = requiredIfChecked.message();
	}

	public boolean isValid(Integer historyMonth, ConstraintValidatorContext cxt) {
		
		if (historyMonth > 0 && historyMonth < 13) {
			
			LocalDateTime localCurrentDate = LocalDateTime.now();
			LocalDateTime localDateTimeWithHistoryMonth = LocalDateTime.now().withMonth(historyMonth);
			
			if (localDateTimeWithHistoryMonth.isAfter(localCurrentDate))
				localCurrentDate = localCurrentDate.minusYears(1);
			
			prepareAcceptableHistoryMonthName(historyMonth, maxAllowedHistoryMonth, cxt);
			LocalDateTime localDateWithCurrentMonth = LocalDateTime.now();
			LocalDateTime localDateWithBackBoundary = LocalDateTime.now().minusMonths(maxAllowedHistoryMonth);
			LocalDateTime localDateWithHistoryMonth = localCurrentDate.withMonth(historyMonth);
			if (!localDateWithCurrentMonth.equals(localDateWithHistoryMonth)) {
				if ((localDateWithHistoryMonth.isAfter(localDateWithBackBoundary))
						|| (localDateWithHistoryMonth.equals(localDateWithBackBoundary))) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return true;// Don't change it.
		}
	}

	private void prepareAcceptableHistoryMonthName(int historyMonth, int maxAllowedHistoryMonth,
			ConstraintValidatorContext cxt) {
		LocalDateTime localDateTimeWithCurrentMonth = LocalDateTime.now();
		LocalDateTime localDateTimeWithBackBoundary = LocalDateTime.now().minusMonths(maxAllowedHistoryMonth);
		String acceptableMonths = "";
		int counter = 1;
		for (LocalDateTime date = localDateTimeWithBackBoundary; date.isBefore(localDateTimeWithCurrentMonth);) {
			if (counter == 1)
				acceptableMonths = date.getMonth().name() + "(" + date.getMonth().getValue() + ")";
			else
				acceptableMonths = acceptableMonths + "," + date.getMonth().name() + "(" + date.getMonth().getValue()
						+ ")";
			date = date.plusMonths(1);
			counter = counter + 1;
		}
		cxt.disableDefaultConstraintViolation();// Will clean the default settings.
		cxt.buildConstraintViolationWithTemplate(
				"Invalid-History-Month(" + historyMonth + "). { Valid => " + acceptableMonths + " }")
				.addConstraintViolation();
	}
}// End of MonthHistoryValidator
