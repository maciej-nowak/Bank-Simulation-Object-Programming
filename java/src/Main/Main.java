//AUTOR: MACIEJ NOWAK

package Main;

import java.io.IOException;
import java.util.Scanner;

import Bank.*;


public class Main 
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		DepositMachine depositMachine = new DepositMachine();
		CashMachine cashMachine = new CashMachine();
		Bank bank = new Bank(depositMachine, cashMachine);
		Scanner in = new Scanner(System.in);
		Person [] persons = new Person[20];
		String choice = "";
		int i = 0;
		
		while(!choice.equals("3"))
		{
			System.out.println("1 - utworz osobe, 2 - wczytaj klienta, 3 - zakoncz");
			choice = in.nextLine();
		
			if(choice.equals("1"))
			{
				String choice2 = "";
				Person person = bank.newPerson();
				persons[i] = person;
				i++;
				
				System.out.println("Czy chcesz zostac klientem banku? 1 - TAK");
				choice2 = in.nextLine();
				
				if(choice2.equals("1"))
				{
					Customer customer = bank.newCustomer(person);
					persons[i] = customer;
					i++;
					bank.bankService(customer);
					bank.saveCustomer(customer);
				}
				else System.out.println("Brak dostepu. Nie jestes klientem banku");
			}
		
			else if(choice.equals("2"))
			{
				Customer customer = bank.loadCustomer();
				persons[i] = customer;
				i++;
				bank.bankService(customer);
				bank.saveCustomer(customer);
			}
			
			else if(choice.equals("3")) return;
		
			//in.close();
			System.out.println("\nTwoje dane: ");
			System.out.println(persons[i-1].toString());
		}
	

	}

}
