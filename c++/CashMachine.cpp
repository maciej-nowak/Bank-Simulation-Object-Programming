#include "CashMachine.hpp"

using namespace std;

void CashMachine::cashOut(Customer *customer)
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
        cout<<"Podaj kwote jaka chcesz wyplacic\n";
        cin>>cash;
        if(cash <= customer->getAccount()->getZloty())
        {
            available = customer->getAccount()->getZloty() - cash;
            customer->getAccount()->setZloty(available);
            cout<<"Wyplata pieniedzy zakonczona pomyslnie\n";
        }
        else cout<<"Za malo srodkow na koncie\n";
    }

    else if(choice == 2)
    {
        cout<<"Podaj kwote jaka chcesz wyplacic\n";
        cin>>cash;
        if(cash <= customer->getAccount()->getEuro())
        {
            available = customer->getAccount()->getEuro() - cash;
            customer->getAccount()->setEuro(available);
            cout<<"Wyplata pieniedzy zakonczona pomyslnie\n";
        }
        else cout<<"Za malo srodkow na koncie\n";
    }

    receiveConfirmation(customer);
    removeCard();
}

void CashMachine::receiveConfirmation(Customer *customer)
{
    cout<<"Saldo konta: "<<customer->getAccount()->getZloty()<<"PLN  "<<customer->getAccount()->getEuro()<<"EUR\n";
}
