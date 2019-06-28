//
// Created by 2018102932 on 28/06/19.
//

#ifndef SIMPLE_EXAMPLE_BANKINGACCOUNT_H
#define SIMPLE_EXAMPLE_BANKINGACCOUNT_H

#include <string>

class BankingAccount {
private:
    double m; // Money / Cash
public:
    BankingAccount();
    ~BankingAccount();

    void add(const double &);
    double get();
    virtual void take(const double &);
    std::string toString();
};


#endif //SIMPLE_EXAMPLE_BANKINGACCOUNT_H
