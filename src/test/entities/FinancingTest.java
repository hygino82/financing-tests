package test.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTest {

	@Test
	public void constructorShouldCreateObjectWhenValidData() {

		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;

		Financing f1 = new Financing(totalAmount, income, months);

		Assertions.assertEquals(totalAmount, f1.getTotalAmount());
		Assertions.assertEquals(income, f1.getIncome());
		Assertions.assertEquals(months, f1.getMonths());
	}

	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {

			double totalAmount = 100000.0;
			double income = 2000.0;
			int months = 20;
			new Financing(totalAmount, income, months);
		});
	}

	@Test
	public void setTotalAmountShouldSetDataWhenValidData() {

		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;

		Financing f1 = new Financing(totalAmount, income, months);

		double newtotalAmount = 90000.0;
		f1.setTotalAmount(newtotalAmount);

		Assertions.assertEquals(newtotalAmount, f1.getTotalAmount());
	}

	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {

			double totalAmount = 100000.0;
			double income = 2000.0;
			int months = 80;

			Financing f1 = new Financing(totalAmount, income, months);

			double newtotalAmount = 110000.0;// esse valor é inválido dele lançar uma exceção
			f1.setTotalAmount(newtotalAmount);
		});
	}

	@Test
	public void setIncomeShouldSetDataWhenValidData() {

		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		Financing f1 = new Financing(totalAmount, income, months);

		double newIncome = 2100.0;
		f1.setIncome(newIncome);

		Assertions.assertEquals(newIncome, f1.getIncome());
	}

	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {

			double totalAmount = 100000.0;
			double income = 2000.0;
			int months = 80;

			Financing f1 = new Financing(totalAmount, income, months);

			double newIncome = 1900.0;
			f1.setIncome(newIncome);

		});
	}

	@Test
	public void setMonthsShouldSetDataWhenValidData() {

		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;

		Financing f1 = new Financing(totalAmount, income, months);

		int updateMonths = 81;
		f1.setMonths(updateMonths);

		Assertions.assertEquals(updateMonths, f1.getMonths());

	}

	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {

			double totalAmount = 100000.0;
			double income = 2000.0;
			int months = 80;

			Financing f1 = new Financing(totalAmount, income, months);
			int updateMonths = 79;

			f1.setMonths(updateMonths);
		});
	}

	@Test
	public void entryShouldCalculateEntryCorrectly() {

		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;

		Financing f1 = new Financing(totalAmount, income, months);
		double entry = totalAmount * 0.2;

		Assertions.assertEquals(entry, f1.entry());
	}

	@Test
	public void quotaShouldCalculateQuotaCorrectly() {
		
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;

		Financing f1 = new Financing(totalAmount, income, months);

		double entry = totalAmount * 0.2;
		double quota = (totalAmount - entry) / months;
		
		Assertions.assertEquals(f1.quota(), quota);
	}
}
