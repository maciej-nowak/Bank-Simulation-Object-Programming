package Bank;

import java.io.*;
import java.util.Scanner;


public class Bank 
{
	//ATTRIBS------------------------------------------------------------------------
	private DepositMachine depositMachine;
	private CashMachine cashMachine;
	
	
	//CONSTRUCTOR-------------------------------------------------------------------
	public Bank(DepositMachine a, CashMachine b)
	{
		depositMachine = a;
		cashMachine = b;
	}
	
	
	//CREATING OBJECTS METHODS------------------------------------------------------
	public Person newPerson()
	{
		String name = "", surname = "", idNumber = "", pesel = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Podaj imie");
		name = in.nextLine();
		System.out.println("Podaj nazwisko");
		surname = in.nextLine();
		System.out.println("Podaj nr dowodu");
		idNumber = in.nextLine();
		System.out.println("Podaj nr pesel");
		pesel = in.nextLine();
		//in.close();
		
		Person person = new Person(name, surname, idNumber, pesel);
		return person;
	}
	
	public Customer newCustomer(Person person) throws IOException
	{
		int pin = 0, idClient = 0;
		String name = "", surname = "", idNumber = "", pesel = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Podaj PIN:");
		pin = in.nextInt();
		name = person.getName();
		surname = person.getSurname();
		idNumber = person.getIdNumber();
		pesel = person.getPesel();
		
		Account account = new Account(0, 0);
		Customer.setCustomerNumber();
		idClient = Customer.getCustomerNumber();
		CreditCard creditCard = new CreditCard(idClient, pin);
		//in.close();
		
		Customer customer = new Customer(name, surname, idNumber, pesel, creditCard, account, idClient);
		return customer;
	}
	
	
	//LOADING AND SAVING CUSTOMER METHODS-------------------------------------------
	public Customer loadCustomer()
	{
		String name = "", surname = "", idNumber = "", pesel = "", pathToFile = "";
		int zloty = 0, euro = 0, idClient = 0, cardNumber = 0, cardPin = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Podaj id Klienta");
		pathToFile = in.nextLine();
		pathToFile = "customers//" + pathToFile + ".txt";
		//in.close();
		
		try
		{
			File file = new File(pathToFile);
			Scanner out = new Scanner(file);
			name = out.nextLine();
			surname = out.nextLine();
			idNumber = out.nextLine();
			pesel = out.nextLine();
			cardNumber = out.nextInt();
			cardPin = out.nextInt();
			zloty = out.nextInt();
			euro = out.nextInt();
			idClient = out.nextInt();		
		}
		catch(FileNotFoundException f)
		{	
			System.out.println("Nie znaleziono pliku");
			System.exit(0);
		}	
		
		CreditCard creditCard = new CreditCard(cardNumber, cardPin);
		Account account = new Account(zloty, euro);
		Customer customer = new Customer(name, surname, idNumber, pesel, creditCard, account, idClient);
		return customer;
	}
	
	public void saveCustomer(Customer customer) throws IOException
	{
			String pathToFile = Integer.toString(customer.getIdClient());
			pathToFile = "customers//" + pathToFile + ".txt";
			
			try
			{
				PrintWriter file = new PrintWriter(pathToFile);
				
				file.println(customer.getName());
				file.println(customer.getSurname());
				file.println(customer.getIdNumber());
				file.println(customer.getPesel());
				file.println(customer.getCreditCard().getCardNumber());
				file.println(customer.getCreditCard().getCardPIN());
				file.println(customer.getAccount().getZloty());
				file.println(customer.getAccount().getEuro());
				file.println(customer.getIdClient());
				
				file.close();
			}	
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Blad zapisu pliku");
				System.exit(0);
			}
	}
	
	
	//MAIN FUNCTION SERVICE---------------------------------------------------------------
	public void bankService(Customer customer) throws InterruptedException
	{
		String choice = "";
		Scanner in = new Scanner(System.in);
		
		while(!choice.equals("3"))
		{
			System.out.println(); 
			System.out.println("1 - wplata, 2 - wyplata, 3 - koniec");
			choice = in.nextLine();
		

			if(choice.equals("1")) depositMachine.cashIn(customer);
			if(choice.equals("2")) cashMachine.cashOut(customer);
		}
		//in.close();
	}
	
	
	//------------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
