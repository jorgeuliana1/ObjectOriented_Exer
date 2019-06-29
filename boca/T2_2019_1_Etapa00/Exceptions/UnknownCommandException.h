//
// Created by ulian on 27/06/19.
//

#ifndef T2_2019_1_ETAPA00_UNKNOWNCOMMANDEXCEPTION_H
#define T2_2019_1_ETAPA00_UNKNOWNCOMMANDEXCEPTION_H

#include <exception>
#include <string>

namespace scienprod_stats {
class UnknownCommandException : public std::exception {
    private:
        std::string message_;

    public:

    /**
     * @param message_
     */
    explicit UnknownCommandException(const std::string &);
    const char * what() const noexcept override;

    // See more here http://peterforgacs.github.io/2017/06/25/Custom-C-Exceptions-For-Beginners/
};
}


#endif //T2_2019_1_ETAPA00_UNKNOWNCOMMANDEXCEPTION_H
