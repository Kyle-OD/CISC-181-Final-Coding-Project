package app.helper;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

public class LoanTest {

	@Test
	public void Loan_TestTotal() {
		double loanAmount = 100000;
		double rate = 0.05;
		int lengthOfLoan = 10;
		double additionalPayment = 0;
		
		Loan l = new Loan(loanAmount, rate, lengthOfLoan, additionalPayment);
		
		double err = 0.001;
		
		assertTrue(l.sumPayments() > loanAmount);
	}
	
	@Test
	public void Loan_TestPrinciple() {
		double loanAmount = 100000;
		double rate = 0.05;
		int lengthOfLoan = 10;
		double additionalPayment = 0;
		
		Loan l = new Loan(loanAmount, rate, lengthOfLoan, additionalPayment);
		
		double err = 0.001;
		
		assertTrue(Math.abs(l.sumPrinciple() - loanAmount) < err);
	}
	
	@Test
	public void Loan_TestInterest() {
		double loanAmount = 100000;
		double rate = 0.05;
		int lengthOfLoan = 10;
		double additionalPayment = 0;
		
		Loan l = new Loan(loanAmount, rate, lengthOfLoan, additionalPayment);
		
		double err = 0.001;
		
		assertTrue(l.sumPayments() - l.sumInterest() - loanAmount < err);
	}

}
