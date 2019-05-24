package app.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import org.apache.poi.ss.formula.functions.*;

public class Loan {
	
	private ArrayList<Payment> paymentList = new ArrayList<Payment>();
	private double loanAmount;
	private double rate;
	private int lengthOfLoan;
	private double additionalPayment;
	private double currentValue;

	public Loan(double loanAmount, double rate, int lengthOfLoan, double additionalPayment) {
		this.loanAmount = loanAmount;
		this.rate = rate;
		this.lengthOfLoan = lengthOfLoan;
		this.additionalPayment = additionalPayment;
		currentValue = this.loanAmount;
		int period = 1;
		do {
			double pmt = round(Finance.pmt(this.rate/12, this.lengthOfLoan*12, -this.loanAmount) + this.additionalPayment,5);
			double ppmt = round(Finance.ppmt(this.rate/12, period, this.lengthOfLoan*12, -this.loanAmount) + this.additionalPayment,5);
			double ipmt = round(Finance.ipmt(this.rate/12, period, this.lengthOfLoan*12, -this.loanAmount),5);
			Payment p = new Payment(pmt,ppmt,ipmt);
			System.out.println("Period: "+period);
			System.out.println("Present Value: "+round(currentValue,2));
			System.out.println("Payment: "+round(p.getPayment(),2));
			System.out.println("Interest Payment: "+round(p.getiPayment(),2));
			System.out.println("Principle Payment: "+round(p.getpPayment(),2));
			System.out.println();
			paymentList.add(p);
			if(currentValue-p.getpPayment()<=0.001) {
				p.setPayment(currentValue);
				currentValue = 0;
				break;
			}	
			else{
				currentValue-=ppmt;
			}
			period++;
		}while(currentValue>0);
	}
	
	public double sumPayments() {
		double tot = 0;
		for(Payment i:paymentList) {
			tot+=i.getPayment();
		}
		return tot;
	}
	
	public double totalInterestPayed() {
		return this.sumPayments()-this.loanAmount;
	}
	
	public void printPayments() {
		System.out.println("Number of Payments: "+paymentList.size());
		for(Payment i:paymentList) {
			System.out.println("Interest Payment: "+i.getiPayment());
			System.out.println("Principle Payment: "+i.getpPayment());
			System.out.println();
		}
	}
	
	public static double round(double value, int places) {
		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

}
