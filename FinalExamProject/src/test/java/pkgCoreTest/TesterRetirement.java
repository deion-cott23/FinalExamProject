package pkgCoreTest;

import static org.junit.Assert.*;
import org.junit.Test;
import pkgCore.Retirement;

public class TesterRetirement {
	
	@Test
	public void Retirement_Test1() {
		double dExpectedToSave = 397.45;
		double dExpectedPV = 1556859.29;
		
		Retirement rt = new Retirement();
		rt.setiYearsToWork(40);
		rt.setdAnnualReturnWorking(0.12);
		rt.setiYearsRetired(25);
		rt.setdAnnualReturnRetired(0.03);
		rt.setdRequiredIncome(-12000);
		rt.setdMonthlySSI(2745);
		
		assertEquals(dExpectedPV, rt.TotalAmountSaved(), 0.03);
		assertEquals(dExpectedToSave, rt.AmountToSave(), 0.03);
	}

}
