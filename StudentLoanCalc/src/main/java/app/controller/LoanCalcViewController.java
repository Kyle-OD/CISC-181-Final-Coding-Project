package app.controller;

import app.StudentCalc;
import app.helper.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;

	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private Label lblTotalPayments;
	
	@FXML
	private Label lblTotalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@FXML
	private TextField AdditionalPayment;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);	
		
		LocalDate localDate = PaymentStartDate.getValue();
		System.out.println(localDate);
		
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		System.out.println(dInterestRate);
		
		int iNbrOfYears = Integer.parseInt(NbrOfYears.getText());
		System.out.println(iNbrOfYears);
		
		double dAdditionalPayment = Double.parseDouble(AdditionalPayment.getText());
		System.out.println(dAdditionalPayment);
		
		Loan l = new Loan(dLoanAmount, dInterestRate, iNbrOfYears, dAdditionalPayment);
		
		lblTotalPayments.setText(Double.toString(Math.round(l.sumPayments())));
		lblTotalInterest.setText(Double.toString(Math.round(l.totalInterestPayed())));
	 
	}
}
