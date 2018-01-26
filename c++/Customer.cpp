#include "Customer.hpp"

using namespace std;

Customer::Customer(string a, string b, string c, string d, CreditCard *e, Account *f, int g): Person(a,b,c,d), creditCard(e), account(f), idClient(g)
{}

void Customer::showData()
{cout<<"Imie: "<<getName()<<"\nNazwisko: "<<getSurname()<<"\nNr dowodu: "<<getIdNumber()<<"\nNr pesel: "<<getPesel()<<"\nId Klienta: "<<idClient<<"\n";}

//SET METHODS
void Customer::setCreditCard(CreditCard *x)
{creditCard = x;}

void Customer::setAccount(Account *x)
{account = x;}

void Customer::setIdClient(int x)
{idClient = x;}

void Customer::setCustomerNumber() //reading customerNumber.txt file and increment it, if not exist, create it and put 1000
{
    string text, pathToFile = "customers/customerNumber.txt";
    ifstream inputFile("customers/customerNumber.txt");
    if(inputFile.eof()) customerNumber = 1000;
    else {getline(inputFile, text); customerNumber = atoi(text.c_str());}

    if(customerNumber < 1000) customerNumber = 1000;
    customerNumber++;
    inputFile.close();

    ofstream outputFile("customers/customerNumber.txt");
    outputFile<<customerNumber<<endl;
    outputFile.close();
}


//GET METHODS
CreditCard* Customer::getCreditCard()
{return creditCard;}

Account* Customer::getAccount()
{return account;}

int Customer::getIdClient()
{return idClient;}

int Customer::getCustomerNumber()
{return customerNumber;}

int Customer::customerNumber = 1000;
