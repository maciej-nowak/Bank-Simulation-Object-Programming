package Bank;

public class Account 
{
	//ATTRIBS---------------------------------------------------------
	private int zloty;
	private int euro;
	
	
	//CONSTRUCTOR----------------------------------------------------
	public Account(int a, int b)
	{
		zloty = a;
		euro = b;
	}
	
	
	//SET METHODS--------------------------------------------------
	public void setZloty(int x)
	{zloty = x;}
	
	public void setEuro(int x)
	{euro = x;}
	
	
	//GET METHODS-------------------------------------------------
	public int getZloty()
	{return zloty;}
	
	public int getEuro()
	{return euro;}
	
	
	//-------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
