package Bank;


public class Person 
{
	//ATTRIBS----------------------------------------------------------------
	private String name; 
	private String surname; 
	private String idNumber; 
	private String pesel;
	
	//CONSTRUCTOR------------------------------------------------------------
	public Person(String a, String b, String c, String d)
	{
		name = a;
		surname = b;
		idNumber = c;
		pesel = d;
	}
	
	//------------------------------------------------------------------------
	public String toString()
	{
		return "Imie: " + name + "\nNazwisko: " + surname + 
		"\nNrdowodu " + idNumber + "\nNr pesel " + pesel; 
	}
	
	
	//SET METHODS--------------------------------------------------------------
	public void setName(String x)
	{name = x;}
	
	public void setSurname(String x)
	{surname = x;}
	
	public void setIdNumber(String x)
	{idNumber = x;}
	
	public void setPesel(String x)
	{pesel = x;}
	
	
	//GET METHODS------------------------------------------------------------
	public String getName()
	{return name;}
	
	public String getSurname()
	{return surname;}
	
	public String getIdNumber()
	{return idNumber;}
	
	public String getPesel()
	{return pesel;}
	
	
	//--------------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
