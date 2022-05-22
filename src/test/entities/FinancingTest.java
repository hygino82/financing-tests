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

	@Test
	public void setTotalAmountShouldReturnValidArguments() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		double newtotalAmount = 60000.0;
		Financing f1 = new Financing(totalAmount, income, months);
		f1.setTotalAmount(newtotalAmount);
		Assertions.assertTrue(f1.getTotalAmount() == newtotalAmount);
	}
	
	@Test
	public void setTotalAmountShouldThrowExceptionWhenGetInvalidArguments() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		
		Financing f1 = new Financing(totalAmount, income, months);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			double newtotalAmount = 160000.0;//esse valor é inválido dele lançar uma exceção
			
			f1.setTotalAmount(newtotalAmount);
		});
	}
	
}
