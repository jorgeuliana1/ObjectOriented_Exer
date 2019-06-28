//
// Created by ulian on 27/06/19.
//

#ifndef T2_2019_1_ETAPA00_UNKNOWNCOMMANDEXCEPTION_H
#define T2_2019_1_ETAPA00_UNKNOWNCOMMANDEXCEPTION_H

#include <exception>

namespace scienprod_stats {
    class UnknownCommandException : public std::exception {
    private:
        const char *file;
        int line;
        const char *func;
        const char *info;

    public:

    /**
     * @param msg
     * @param file_
     * @param line_
     * @param func_
     * @param info_
     */
    UnknownCommandException(const char *, const char *, int, const char *, const char *);

    const char *get_file();
    int get_line();
    const char *get_func();
    const char *get_info();

    // See more here http://peterforgacs.github.io/2017/06/25/Custom-C-Exceptions-For-Beginners/
};
}


#endif //T2_2019_1_ETAPA00_UNKNOWNCOMMANDEXCEPTION_H
