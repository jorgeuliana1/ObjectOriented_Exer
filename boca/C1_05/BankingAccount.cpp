//
// Created by 2018102932 on 28/06/19.
//

#include <sstream>
#include "BankingAccount.h"

using namespace std;

BankingAccount::BankingAccount() {
    this->m = 0.0;
}

BankingAccount::~BankingAccount()=default;

void BankingAccount::add(const double & value) {
    this->m += value;
}

string BankingAccount::toString() {
    string currency = "R$";
    stringstream ss;
    ss.precision(3);
    string decimal = ",";
    int integer_p = (int)this->m;
    int decimal_p = (int)(100*(this->m - integer_p));

    ss << currency << integer_p << decimal << decimal_p;

    return ss.str();
}

double BankingAccount::get() {
    return this->m;
}

void BankingAccount::take(const double & value) {
}