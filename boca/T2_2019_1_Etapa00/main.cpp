#include <iostream>
#include "University/University.h"
#include "Command/Command.h"
#include "Exceptions/UnknownCommandException.h"

using namespace scienprod_stats;

int main() {
    try {
        Command potato("csv", "potata");
    } catch(UnknownCommandException & e) {
        std::cout << e.what() << std::endl;
    }
    return 0;
}