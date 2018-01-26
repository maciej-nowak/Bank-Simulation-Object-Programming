#ifndef CREDITCARD_HPP
#define CREDITCARD_HPP

#include<iostream>

using namespace std;

class CreditCard
{
    private:
    int cardNumber, cardPIN;

    public:

    CreditCard(int a, int b);

    //SET METHODS
    void setCardNumber(int x);
    void setCardPIN(int x);

    //GET METHODS
    int getCardNumber();
    int getCardPIN();

};

#endif
