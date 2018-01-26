package Bank;

import java.util.Scanner;


public class CashMachine extends Machine
{
	//CASH MACHINE SERVICE--------------------------------------------------------
	public void cashOut(Customer customer) throws InterruptedException
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
			System.out.println("Podaj kwote jaka chcesz wyplacic");
			cash = in.nextInt();
			if(cash <= customer.getAccount().getZloty())
			{
				available = customer.getAccount().getZloty() - cash;
				customer.getAccount().setZloty(available);
				System.out.println("Wyplata pieniedzy zakonoczona pomyslnie");
			}
			else System.out.println("Za malo srodkow na koncie");
		}
		
		else if(choice.equals("2"))
		{
			System.out.println("Podaj kwote jaka chcesz wyplacic");
			cash = in.nextInt();
			if(cash <= customer.getAccount().getEuro())
			{
				available = customer.getAccount().getEuro() - cash;
				customer.getAccount().setEuro(available);
				System.out.println("Wyplata pieniedzy zakonoczona pomyslnie");
			}
			else System.out.println("Za malo srodkow na koncie");
		}
		
		receiveConfirmation(customer);
		removeCard();

		//in.close();
	}
	
	public void receiveConfirmation(Customer customer)
	{
		System.out.println("Saldo konta: " + customer.getAccount().getZloty() + "PLN " + customer.getAccount().getEuro() + "EUR");
	}
	
	
	//-----------------------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
