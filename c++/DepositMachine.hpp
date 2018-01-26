#ifndef DEPOSITMACHINE_HPP
#define DEPOSITMACHINE_HPP

#include "Machine.hpp"

using namespace std;

class DepositMachine : public Machine
{
    public:
    void cashIn(Customer *customer);
    void receiveConfirmation(Customer *customer);

};

#endif
