package Bank;

import java.util.Scanner;
import java.lang.InterruptedException;

public abstract class Machine 
{
	//MACHINE SERVICE--------------------------------------------------------------------
	public void insertCard() throws InterruptedException
	{
		System.out.println("Wloz karte (czekaj)");
		Thread.sleep(5000); //time stoping
	}
	
	public void removeCard() throws InterruptedException
	{
		System.out.println("Wyciagnij karte (czekaj)");
		Thread.sleep(5000); //time stoping
	}
	
	public abstract void receiveConfirmation(Customer customer);
	
	public boolean enterPIN(Customer customer) 
	{
		String text = "";
		System.out.println("Wprowadz kod PIN");
		Scanner in = new Scanner(System.in);
		int pin = 0;
		text = in.nextLine();
		String cust = Integer.toString(customer.getCreditCard().getCardPIN());
		if(text.equals(cust)) return true;
		else return false;
	}
	
	
	//------------------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
