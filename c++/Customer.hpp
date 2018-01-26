#ifndef CUSTOMER_HPP
#define CUSTOMER_HPP

#include<cstdlib>
#include<fstream>
#include<sstream>
#include "CreditCard.hpp"
#include "Account.hpp"
#include "Person.hpp"

using namespace std;

class Customer : public Person
{
    private:
    CreditCard *creditCard;
    Account *account;
    int idClient;
    static int customerNumber;

    public:

    Customer(string a, string b, string c, string d, CreditCard *e, Account *f, int g);
    void showData();

    //SET METHODS
    void setCreditCard(CreditCard *x);
    void setAccount(Account *x);
    void setIdClient(int x);
    static void setCustomerNumber();

    //GET METHODS
    CreditCard* getCreditCard();
    Account* getAccount();
    int getIdClient();
    static int getCustomerNumber();

};

#endif
