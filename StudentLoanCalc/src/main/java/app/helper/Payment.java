package app.helper;

public class Payment {
	
	private double payment;
	private double pPayment;
	private double iPayment;	

	public Payment(double payment, double pPayment, double iPayment) {
		this.payment = payment;
		this.iPayment = iPayment;
		this.pPayment = pPayment;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getpPayment() {
		return pPayment;
	}

	public void setpPayment(double pPayment) {
		this.pPayment = pPayment;
	}

	public double getiPayment() {
		return iPayment;
	}

	public void setiPayment(double iPayment) {
		this.iPayment = iPayment;
	}


}
