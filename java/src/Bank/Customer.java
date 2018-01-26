package Bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.*;


public class Customer extends Person
{
	//ATTRIBS-------------------------------------------------------------------------------------
	private CreditCard creditCard;
	private Account account;
	private int idClient;
	private static int customerNumber = 1000;
	
	//CONSTRUCTOR---------------------------------------------------------------------------------
	public Customer(String a, String b, String c, String d, CreditCard e, Account f, int g)
	{
		super(a, b, c, d);
		creditCard = e;
		account = f;
		idClient = g;
	}
	
	//-------------------------------------------------------------------------------------------
	public String toString()
	{
		return "Imie: " + getName() + "\nNazwisko: " + getSurname() + 
		"\nNrdowodu " + getIdNumber() + "\nNr pesel " + getPesel() + "\nId Klienta: " + idClient; 
	}
	
	
	//SET METHODS--------------------------------------------------------------------------------
	public void setCreditCard(CreditCard x)
	{creditCard = x;}
	
	public void setAccount(Account x)
	{account = x;}
	
	public void setIdClient(int x)
	{idClient = x;}

	public static void setCustomerNumber() throws IOException
	{
		String text;
		int temp = 0;

		try
		{
			File file = new File("customers/customerNumber.txt");
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			if(raf.length() == 0) 
			{
				raf.writeBytes("1000");
				raf.seek(0);
			}
			
			text = raf.readLine();
			temp = Integer.parseInt(text);
			temp++;
			raf.seek(0);
			text = Integer.toString(temp);
			raf.writeBytes(text);
			raf.close();
		}	
		catch(FileNotFoundException f)
		{
			System.out.println("Nie znaleziono pliku");
			System.exit(0);
			
		}
		customerNumber = temp;
			
	}
	
	//GET METHODS---------------------------------------------------------------------------
	public CreditCard getCreditCard()
	{return creditCard;}
	
	public Account getAccount()
	{return account;}
	
	public int getIdClient()
	{return idClient;}
	
	public static int getCustomerNumber()
	{return customerNumber;}
	
	
	//-------------------------------------------------------------------------------------
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub

	}

}
