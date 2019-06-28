//
// Created by 2018102932 on 28/06/19.
//

#ifndef C1_05_NORMALACCOUNT_H
#define C1_05_NORMALACCOUNT_H


#include "BankingAccount.h"

class NormalAccount : public BankingAccount{
public:
    NormalAccount();
    void take(const double &) override;
};


#endif //C1_05_NORMALACCOUNT_H
