package Bank;

import java.util.Scanner;


public class DepositMachine extends Machine
{
	//DEPOSIT MACHINE SERVICE--------------------------------------------------------
	public void cashIn(Customer customer) throws InterruptedException
	{
		int cash = 0, available = 0;
		String choice = "";

		insertCard();
		
		boolean check = enterPIN(customer);
		while(!check)
		{
			System.out.println("Podales zly PIN. Wprowadz ponownie");
			check = enterPIN(customer);
		}
		
		System.out.println("Wybierz walute: 1 - zloty, 2 - euro");
		Scanner in = new Scanner(System.in);
		choice = in.nextLine();
		
		if(choice.equals("1"))
		{
			System.out.println("Podaj kwote jaka chcesz wplacic");
			cash = in.nextInt();
			available = customer.getAccount().getZloty() + cash;
			customer.getAccount().setZloty(available);
		}
		
		else if(choice.equals("2"))
		{
			System.out.println("Podaj kwote jaka chcesz wplacic");
			cash = in.nextInt();
			available = customer.getAccount().getEuro() + cash;
			customer.getAccount().setEuro(available);
		}
		
		receiveConfirmation(customer);
		removeCard();
		//in.close();
	}
	
	public void receiveConfirmation(Customer customer)
	{
		System.out.println("Wplata pieniedzy zakonoczona pomyslnie");
		System.out.println("Saldo konta: " + customer.getAccount().getZloty() + "PLN " + customer.getAccount().getEuro() + "EUR");
	}
	
	
	//---------------------------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
