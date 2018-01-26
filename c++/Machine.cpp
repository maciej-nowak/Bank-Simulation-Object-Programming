#include "Machine.hpp"

using namespace std;

void Machine::insertCard()
{
    cout<<"Wloz karte. (Czekaj)\n";
    Sleep(5 * CLOCKS_PER_SEC); //using windows.h
}

void Machine::removeCard()
{
    cout<<"Wyciagnij karte. (Czekaj)\n";
    Sleep(5 * CLOCKS_PER_SEC); //using windows.h
}

bool Machine::enterPIN(Customer *customer)
{
    int pin;
    cout<<"Wprowadz kod PIN\n";
    cin>>pin;
    if(pin == customer->getCreditCard()->getCardPIN()) return true;
    else return false;
}
