#include "Bank.hpp"

using namespace std;

Bank::Bank(DepositMachine a, CashMachine b)
{
    depositMachine = a;
    cashMachine = b;
}

Person* Bank::newPerson()
{
    string name, surname, idNumber, pesel;
    cout<<"Podaj imie:\n";
    cin>>name;
    cout<<"Podaj nazwisko:\n";
    cin>>surname;
    cout<<"Podaj nr dowodu:\n";
    cin>>idNumber;
    cout<<"Podaj nr pesel:\n";
    cin>>pesel;
    Person *person = new Person(name, surname, idNumber, pesel);

    return person;
}

Customer* Bank::newCustomer(Person *person)
{
    int pin, idClient;
    string name, surname, idNumber, pesel;
    cout<<"Podaj PIN:\n";
    cin>>pin;
    name = person->getName();
    surname = person->getSurname();
    idNumber = person->getIdNumber();
    pesel = person->getPesel();
    Account *account = new Account(0,0);
    Customer::setCustomerNumber();
    idClient = Customer::getCustomerNumber();
    CreditCard *creditCard = new CreditCard(idClient, pin);
    Customer *customer = new Customer(name, surname, idNumber, pesel, creditCard, account, idClient);

    return customer;
}

Customer* Bank::loadCustomer()
{
    string name, surname, idNumber, pesel, number, pin, pln, eur, id, text, pathToFile;
    int zloty, euro, idClient, cardNumber, cardPin;
    cout<<"Podaj ID klienta:\n";
    cin.ignore();
    getline(cin, pathToFile);
    pathToFile = "customers/"+pathToFile+".txt";
    ifstream customerFile(pathToFile.c_str());

    getline(customerFile, text); name = text; if(name == "") {cout<<"Nie znaleziono pliku\n"; exit(EXIT_FAILURE);}
    getline(customerFile, text); surname = text;
    getline(customerFile, text); idNumber = text;
    getline(customerFile, text); pesel = text;

    getline(customerFile, text); number = text; cardNumber = atoi(number.c_str());
    getline(customerFile, text); pin = text; cardPin = atoi(pin.c_str());
    CreditCard *creditCard = new CreditCard(cardNumber, cardPin);

    getline(customerFile, text); pln = text; zloty = atoi(pln.c_str());
    getline(customerFile, text); eur = text; euro = atoi(eur.c_str());
    Account *account = new Account(zloty, euro);

    getline(customerFile, text); id = text; idClient = atoi(id.c_str());
    customerFile.close();
    Customer *customer = new Customer(name, surname, idNumber, pesel, creditCard, account, idClient);

    return customer;
}

void Bank::saveCustomer(Customer *customer)
{
    ostringstream path;
    path<<customer->getIdClient();
    string str = path.str();
    str = "customers/"+str+".txt";
    ofstream customerFile(str.c_str());
    customerFile<<customer->getName()<<endl;
    customerFile<<customer->getSurname()<<endl;
    customerFile<<customer->getIdNumber()<<endl;
    customerFile<<customer->getPesel()<<endl;
    customerFile<<customer->getCreditCard()->getCardNumber()<<endl;
    customerFile<<customer->getCreditCard()->getCardPIN()<<endl;
    customerFile<<customer->getAccount()->getZloty()<<endl;
    customerFile<<customer->getAccount()->getEuro()<<endl;
    customerFile<<customer->getIdClient()<<endl;

    customerFile.close();
}

void Bank::bankService(Customer *customer)
{
    int choice = 0;

    while(choice != 3)
    {
        system("CLS");
        cout<<"1 - wplata, 2 - wyplata, 3 - zakoncz\n";
        cin>>choice;

        if(choice == 1) depositMachine.cashIn(customer);
        if(choice == 2) cashMachine.cashOut(customer);
    }
}
