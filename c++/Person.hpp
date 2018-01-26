#ifndef PERSON_HPP
#define PERSON_HPP

#include<iostream>
#include<string>

using namespace std;

class Person
{
    private:
    string name, surname, idNumber, pesel;

    public:

    Person(string a, string b, string c, string d);
    virtual void showData();

    //SET METHODS
    void setName(string x);
    void setSurname(string x);
    void setIdNumber(string x);
    void setPesel(string x);

    //GET METHODS
    string getName();
    string getSurname();
    string getIdNumber();
    string getPesel();

};

#endif

