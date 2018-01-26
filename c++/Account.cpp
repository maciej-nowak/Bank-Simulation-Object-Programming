#include "Account.hpp"

Account::Account(int a, int b): zloty(a), euro(b)
{}

//SET METHODS
void Account::setZloty(int x)
{zloty = x;}

void Account::setEuro(int x)
{euro = x;}

//GET METHODS
int Account::getZloty()
{return zloty;}

int Account::getEuro()
{return euro;}

