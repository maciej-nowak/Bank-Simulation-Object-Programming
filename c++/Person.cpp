#include "Person.hpp"

using namespace std;

Person::Person(string a, string b, string c, string d): name(a), surname(b), idNumber(c), pesel(d)
{}

void Person::showData()
{cout<<"Imie: "<<name<<"\nNazwisko: "<<surname<<"\nNr dowodu: "<<idNumber<<"\nNr pesel: "<<pesel<<"\n";}


//SET METHODS---------------------------------
void Person::setName(string x)
{name = x;}

void Person::setSurname(string x)
{surname = x;}

void Person::setIdNumber(string x)
{idNumber = x;}

void Person::setPesel(string x)
{pesel = x;}


//GET METHODS---------------------------------
string Person::getName()
{return name;}

string Person::getSurname()
{return surname;}

string Person::getIdNumber()
{return idNumber;}

string Person::getPesel()
{return pesel;}

