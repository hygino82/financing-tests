package test.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTest {

	@Test
	public void constructorShouldThrowExceptionWhenGetInvalidArguments() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			double totalAmount = 100000.0;
			double income = 2000.0;
			int months = 20;
			new Financing(totalAmount, income, months);
		});
	}

	@Test
	public void constructorShouldReturnValidValues() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		Financing f1 = new Financing(totalAmount, income, months);

		double expectedEntry = 20000.0;
		double expectedQuota = 1000.0;
		Assertions.assertEquals(totalAmount, f1.getTotalAmount());
		Assertions.assertEquals(expectedEntry, f1.entry());
		Assertions.assertTrue(expectedQuota == f1.quota());
	}
}
