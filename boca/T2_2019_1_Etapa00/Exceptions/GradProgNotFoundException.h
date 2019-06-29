//
// Created by ulian on 28/06/19.
//

#ifndef T2_2019_1_ETAPA00_GRADPROGNOTFOUNDEXCEPTION_H
#define T2_2019_1_ETAPA00_GRADPROGNOTFOUNDEXCEPTION_H


namespace scienprod_stats {
class GradProgNotFoundException : public std::exception {
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
    GradProgNotFoundException(const char *, const char *, int, const char *, const char *);

    const char *get_file();
    int get_line();
    const char *get_func();
    const char *get_info();

};
}


#endif //T2_2019_1_ETAPA00_GRADPROGNOTFOUNDEXCEPTION_H
