//
// Created by 2018102932 on 28/06/19.
//

#ifndef C1_05_SPECIALACCOUNT_H
#define C1_05_SPECIALACCOUNT_H


#include "BankingAccount.h"

class SpecialAccount : public BankingAccount {
public:
    SpecialAccount();
    void take(const double &) override;
};


#endif //C1_05_SPECIALACCOUNT_H
