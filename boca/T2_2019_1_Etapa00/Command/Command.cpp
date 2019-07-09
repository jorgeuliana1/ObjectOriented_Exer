//
// Created by ulian on 29/06/19.
//

#include <complex>
#include "Command.h"
#include "../Exceptions/UnknownCommandException.h"

using namespace std;
using namespace scienprod_stats;

Command::Command(const string & command, const string & sub_command1, const string & sub_command2) {
    sc.clear();
    sc.insert(sc.begin(), sub_command1);
    sc.insert(sc.begin(), sub_command2);

    // Interpreting the command string.

    if(command == "ppg")
        c = CommandConst::PPG;
    else if(command == "ies")
        c = CommandConst::IES;
    else if(command == "csv")
        c = CommandConst::CSV;
    else {
        // Shows the message "Comando desconhecido"
        throw UnknownCommandException("Comando desconhecido");
    }
}

Command::Command(const string & command, const string & sub_command) : Command(command, sub_command, "")
{
}

Command::~Command()=default;

CommandConst Command::get() {
    return c;
}

string Command::get(const int & index) {
    if(index == 0) {
        if(c == CommandConst::IES)
            return "ies";
        else if(c == CommandConst::CSV)
            return "csv";
        else if(c == CommandConst::PPG)
            return "ppg";
    }

    if(index > sc.size())
        return nullptr;

    else return sc[index - 1];
}

void Command::execute(Stats & stats) {
    //TODO: Create the IES command executor.
    //TODO: Create the CSV command executor.
    //TODO: Create the PPG command executor.
    //TODO: Create the PPG type interpreter.
}