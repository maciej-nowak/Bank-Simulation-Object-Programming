#include "CreditCard.hpp"

using namespace std;

CreditCard::CreditCard(int a, int b): cardNumber(a), cardPIN(b)
{}

//SET METHODS
void CreditCard::setCardNumber(int x)
{cardNumber = x;}

void CreditCard::setCardPIN(int x)
{cardPIN = x;}

//GET METHODS
int CreditCard::getCardNumber()
{return cardNumber;}

int CreditCard::getCardPIN()
{return cardPIN;}
