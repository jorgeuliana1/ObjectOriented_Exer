//
// Created by ulian on 29/06/19.
//

#ifndef T2_2019_1_ETAPA00_COMMAND_H
#define T2_2019_1_ETAPA00_COMMAND_H


#include <string>
#include <vector>
#include "../University/University.h"

namespace scienprod_stats {
enum CommandConst {
    PPG,
    IES,
    CSV
};

class Command {
private:
    CommandConst c; // Command
    std::vector<std::string> sc; // Sub commands
public:
    /**
     * @param Command string.
     * @param Subcommand strings.
     */
    Command(const std::string &, const std::string &, const std::string &);
    /**
     * @param Command string.
     * @param Subcommand string.
     */
    Command(const std::string &, const std::string &);

    ~Command();

    /**
     * @param Index of the element, index 0 for the command name, index 1 or 2 for the subcommands.
     * @return Returns the wanted element.
     */
    std::string get(const int &);

    /**
     * @return Returns the CommandConst of the command.
     */
    CommandConst get();

    /**
     * Executes the command.
     */
    void execute(std::vector<University &> &, std::vector<GradProgram *> &, std::vector<Publication *> &);
};
}

#endif //T2_2019_1_ETAPA00_COMMAND_H
