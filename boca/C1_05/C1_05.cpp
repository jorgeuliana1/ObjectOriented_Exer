//
// Created by 2018102932 on 28/06/19.
//

#include <iostream>
#include "BankingAccount.h"
#include "NormalAccount.h"
#include "SpecialAccount.h"

using namespace std;

int main() {
    BankingAccount* a;
    string type;
    cin >> type;
    if(type == "C")
        a = new NormalAccount();
    else if(type == "E")
        a = new SpecialAccount();
    else
        return 0;

    while(true) {
        string com;
        cin >> com;
        double value;
        if(com != ".")
            break;
        cin >> value;

        if(com == "+")
            a->add(value);
        if(com == "-")
            a->take(value);

        cout << a->toString() << endl;

    }

    cout << a->toString() << endl;

    delete a;

    return 0;
}
