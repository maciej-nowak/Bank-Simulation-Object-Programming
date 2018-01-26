#include "DepositMachine.hpp"

using namespace std;

void DepositMachine::cashIn(Customer *customer)
{
    int choice, cash, available;

    insertCard();

    bool check = enterPIN(customer);
    while(!check)
    {
        cout<<"Podales zly PIN. Wprowadz ponownie\n";
        check = enterPIN(customer);
    }

    cout<<"Wybierz walute: 1 - zloty, 2 - euro\n";
    cin>>choice;

    if(choice == 1)
    {
        cout<<"Podaj kwote jaka chcesz wplacic\n";
        cin>>cash;
        available = customer->getAccount()->getZloty()+cash;
        customer->getAccount()->setZloty(available);
    }


    else if(choice == 2)
    {
        cout<<"Podaj kwote jaka chcesz wplacic\n";
        cin>>cash;
        available = customer->getAccount()->getEuro()+cash;
        customer->getAccount()->setEuro(available);
    }

    receiveConfirmation(customer);
    removeCard();
    available = 0; cash = 0;
}

void DepositMachine::receiveConfirmation(Customer *customer)
{
    cout<<"Wplata pieniedzy zakonczona pomyslnie\n";
    cout<<"Saldo konta: "<<customer->getAccount()->getZloty()<<"PLN  "<<customer->getAccount()->getEuro()<<"EUR\n";
}

