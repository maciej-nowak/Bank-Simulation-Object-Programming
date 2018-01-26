#ifndef BANK_HPP
#define BANK_HPP

#include "CashMachine.hpp"
#include "DepositMachine.hpp"
#include "Customer.hpp"

using namespace std;

class Bank
{
    private:
    DepositMachine depositMachine;
    CashMachine cashMachine;

    public:

    Bank(DepositMachine a, CashMachine b);

    Person* newPerson();
    Customer* newCustomer(Person *person);
    Customer* loadCustomer();
    void saveCustomer(Customer *customer);
    void bankService(Customer *customer);

    //SET METHODS
    void setDepositMachine(DepositMachine x);
    void setCashMachine(CashMachine x);

    //GET METHODS
    DepositMachine getDepositMachine();
    CashMachine getCashMachine();

};

#endif
