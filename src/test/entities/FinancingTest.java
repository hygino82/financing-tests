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

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			double totalAmount = 100000.0;
			double income = 2000.0;
			int months = 80;

			Financing f1 = new Financing(totalAmount, income, months);

			double newtotalAmount = 160000.0;// esse valor é inválido dele lançar uma exceção
			f1.setTotalAmount(newtotalAmount);
		});
	}

	@Test
	public void setIncomeShouldReturnValidArguments() {
		
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		Financing f1 = new Financing(totalAmount, income, months);

		double newIncome = 3000.0;
		f1.setIncome(newIncome);

		Assertions.assertTrue(f1.getIncome() == newIncome);
	}

	public void setIncomeShouldThrowExceptionWhenGetInvalidArguments() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			double totalAmount = 100000.0;
			double income = 2000.0;
			int months = 80;
			Financing f1 = new Financing(totalAmount, income, months);

			double newIncome = 500.0;
			f1.setIncome(newIncome);
		});
	}

	@Test
	public void setMonthsShouldReturnValidArguments() {
		
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;

		Financing f1 = new Financing(totalAmount, income, months);
		int updateMonths = 100;

		f1.setMonths(updateMonths);
		Assertions.assertTrue(f1.getMonths() == updateMonths);

	}
	
	public void setMonthsShouldThrowExceptionWhenGetInvalidArguments() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			double totalAmount = 100000.0;
			double income = 2000.0;
			int months = 80;

			Financing f1 = new Financing(totalAmount, income, months);
			int updateMonths = 10;

			f1.setMonths(updateMonths);
		});
	}
}
