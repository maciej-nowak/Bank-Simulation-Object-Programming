package Bank;

public class CreditCard 
{
	//ATTRIBS---------------------------------------------------------------
	private int cardNumber;
	private int cardPIN;
	
	//CONSTRUCTOR----------------------------------------------------------
	public CreditCard(int a, int b)
	{
		cardNumber = a;
		cardPIN = b;
	}
	
	
	//SET METHODS---------------------------------------------------------
	public void setCardNumber(int x)
	{cardNumber = x;}
	
	public void setCardPIN(int x)
	{cardPIN = x;}
	
	
	//GET METHODS---------------------------------------------------------
	public int getCardNumber()
	{return cardNumber;}
	
	public int getCardPIN()
	{return cardPIN;}

	
	//----------------------------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
