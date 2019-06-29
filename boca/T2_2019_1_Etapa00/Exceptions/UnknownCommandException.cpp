//
// Created by ulian on 27/06/19.
//

#include "UnknownCommandException.h"

using namespace std;
using namespace scienprod_stats;

UnknownCommandException::UnknownCommandException(const string & message) {
    message_ = message;
}

const char * UnknownCommandException::what() const noexcept {
    return message_.c_str();
}