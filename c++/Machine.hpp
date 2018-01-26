#ifndef MACHINE_HPP
#define MACHINE_HPP

#include<iostream>
#include<string>
#include "Customer.hpp"
#include<windows.h>
#include<ctime>

using namespace std;

class Machine
{
    public:
    void insertCard();
    void removeCard();
    virtual void receiveConfirmation(Customer *customer) = 0;
    bool enterPIN(Customer *customer);

};

#endif

