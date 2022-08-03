package net.brianlucius.abstractdemon;

public class CreditCardPayment extends Payment {

	private String cardNumber, ownerName, expDate; 
	
	public CreditCardPayment(double amount, String cardNumber, String ownerName, String expDate) {
		super(amount);
		this.cardNumber = cardNumber;
		this.ownerName = ownerName;
		this.expDate = expDate;
	}
	
	@Override
	public void paymentDetails() {
		super.paymentDetails();
		System.out.println("Card Number: " + cardNumber);
		System.out.println("Name: " + ownerName);
		System.out.println("Exp Date: " + expDate);
	}
}
