//
// Created by ulian on 25/06/19.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include "Person.h"
#include "Athlete.h"

using namespace std;

string uppercasestr(const string & s) {
    string str = s;
    for(auto & c : str) c = toupper(c);
    return str;
}

bool compareByName(Person* a, Person* b) {
    string s1, s2;

    s1 = a->getName();
    s2 = b->getName();

    return s1 < s2;
}

bool compareByAge(Person* a, Person* b) {
    return a->getAge() < b->getAge();
}

bool compareByHeight(Person* a, Person* b) {
    return a->getHeight() < b->getHeight();
}

bool compareByTeam(Person* a, Person* b) {
    string s1, s2;
    s1 = ((Athlete*)a)->getTeam();
    s2 = ((Athlete*)b)->getTeam();

    s1 = uppercasestr(s1);
    s2 = uppercasestr(s2);

    return s1 < s2;
}

vector<Person*> updateIDs(vector<Person*> p) {
    vector<Person*> ret;

    int size = p.size();
    int counter = 0;

    for(int i = 0; i < size; i++) {

        Person* p1 = p[i];
        ret.insert(ret.end(), p1);

    }

    p.clear();

    size = ret.size();

    for(int i = 0; i < size; i++) {

        Person* p1 = ret[i];
        p1->setID(counter++);
        p.insert(p.end(), p1);

    }

    return p;
}

int main() {

    long unsigned int id = 0;
    vector<Person*> p;

    while(true) {
        string command;
        cin >> command;

        if(command == "sair")
            break;

        if(command == "cadastrar") {
            string name, team;
            unsigned int age;
            double height;

            cin >> name;
            cin >> age;
            cin >> height;
            cin >> team;

            Person* person = new Athlete(name, age, height, id, team);
            p.insert(p.end(), person);

            id++;
        }

        if(command == "listar") {
            for(Person* person : p)
                cout << ((Athlete*)person)->toString() << endl;
        }

        if(command == "excluir") {
            long unsigned int index;
            cin >> index;

            p.erase(p.begin() + index);
        }

        if(command == "ordenar") {
            string subcommand;
            cin >> subcommand;

            if(subcommand == "N") {
                sort(p.begin(), p.end(), compareByName);
            }

            if(subcommand == "I") {
                sort(p.begin(), p.end(), compareByAge);
            }

            if(subcommand == "A") {
                sort(p.begin(), p.end(), compareByHeight);
            }

            if(subcommand == "T") {
                sort(p.begin(), p.end(), compareByTeam);
            }

        }

        p = updateIDs(p);
    }

    return 0;
}