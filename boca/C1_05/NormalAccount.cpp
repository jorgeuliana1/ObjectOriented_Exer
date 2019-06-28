//
// Created by 2018102932 on 28/06/19.
//

#include "NormalAccount.h"

NormalAccount::NormalAccount() : BankingAccount() {}
void NormalAccount::take(const double & value) {
    add(-get()*(1.01));
}