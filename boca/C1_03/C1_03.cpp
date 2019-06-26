//
// Created by ulian on 25/06/19.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include "Person.h"

using namespace std;

bool compareByName(Person a, Person b) {
    return a.getName() < b.getName();
}

bool compareByAge(Person a, Person b) {
    return a.getAge() < b.getAge();
}

bool compareByHeight(Person a, Person b) {
    return a.getHeight() < b.getHeight();
}

vector<Person> updateIDs(vector<Person> p) {
    vector<Person> ret;

    int size = p.size();
    int counter = 0;

    for(int i = 0; i < size; i++) {

        Person p1 = p[i];
        ret.insert(ret.end(), p1);

    }

    p.clear();

    size = ret.size();

    for(int i = 0; i < size; i++) {

        Person p1 = ret[i];
        p1.setID(counter++);
        p.insert(p.end(), p1);

    }

    return p;
}

int main() {

    long unsigned int id = 0;
    vector<Person> p;

    while(true) {
        string command;
        cin >> command;

        if(command == "sair")
            break;

        if(command == "cadastrar") {
            string name;
            unsigned int age;
            double height;

            cin >> name;
            cin >> age;
            cin >> height;

            Person person(name, age, height, id);
            p.insert(p.end(), person);

            id++;
        }

        if(command == "listar") {
            for(Person person : p)
                cout << person.toString() << endl;
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

        }

        p = updateIDs(p);
    }

    return 0;
}