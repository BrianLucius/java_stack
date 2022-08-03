package net.brianlucius.abstractdemon;

public class PaymentTest {

	public static void main(String[] args) {
//		payment laptop = new Payment(2000);

	CashPayment tacos = new CashPayment(2.00);
	tacos.paymentDetails();
	
	CreditCardPayment laptop = new CreditCardPayment(2000,"1234556", "Brian", "07/2024");
	laptop.paymentDetails();
		
	}

}
