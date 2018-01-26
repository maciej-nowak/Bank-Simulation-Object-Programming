#ifndef CASHMACHINE_HPP
#define CASHMACHINE_HPP

#include "Machine.hpp"

using namespace std;

class CashMachine : public Machine
{
    public:
    void cashOut(Customer *customer);
    void receiveConfirmation(Customer *customer);

};

#endif
