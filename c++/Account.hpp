#ifndef ACCOUNT_HPP
#define ACCOUNT_HPP

#include<iostream>

using namespace std;

class Account
{
    private:
    int zloty, euro;

    public:

    Account(int a, int b);

    //SET METHODS
    void setZloty(int x);
    void setEuro(int x);

    //GET METHODS
    int getZloty();
    int getEuro();

};

#endif
