//AUTOR: MACIEJ NOWAK

#include <iostream>
#include "Customer.hpp"
#include "Bank.hpp"

int main()
{
    DepositMachine depositMachine;
    CashMachine cashMachine;
    Bank bank(depositMachine, cashMachine);
    Person *persons[10];
    int choice;
    int i = 0;

    while(choice != 3)
    {
        cout<<"1 - utworz osobe, 2 - wczytaj klienta, 3 - zakoncz\n";
        cin>>choice;

        if(choice == 1)
        {
            int choice2;
            Person *person = bank.newPerson();
            persons[i] = person;
            i++;
            cout<<"Czy chcesz zostac klientem banku? 1 - TAK\n";
            cin>>choice2;
            if(choice2 == 1)
            {
                Customer *customer = bank.newCustomer(person);
                persons[i] = customer;
                i++;
                bank.bankService(customer);
                bank.saveCustomer(customer);
            }
            else cout<<"Brak dostepu. Nie jestes klientem banku\n";
        }

        else if(choice == 2)
        {
            Customer *customer = bank.loadCustomer();
            persons[i] = customer;
            i++;
            bank.bankService(customer);
            bank.saveCustomer(customer);
        }

        else if(choice == 3) return 0;

        system("CLS");
        persons[i-1]->showData();

    }
    return 0;
}
