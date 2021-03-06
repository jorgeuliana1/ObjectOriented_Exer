//
// Created by ulian on 27/06/19.
//

#include <sstream>
#include "Publication.h"

using namespace std;

namespace scienprod_stats {

Publication::Publication(const std::string & title, const std::string & language, const std::string & nature, const std::string & city) {
    t = title;
    l = language;
    n = nature;
    c = city;
}

Publication::~Publication()=default;

string Publication::title() const {
    return t;
}

string Publication::language() const {
    return l;
}

string Publication::nature() const {
    return n;
}

string Publication::city() const {
    if(c.empty())
        return "-";
    return c;
}

void Publication::set_pages(const int & begin, const int & end) {
    if(begin < 0 || end < 0)
        return;
    if(begin > end)
        return;

    p.begin = begin;
    p.end = end;
    p.has_page = true;
}

int Publication::size() const {
    if(p.has_page)
        return p.end - p.begin + 1;
    else
        return 0;
}

bool Publication::compare(Publication * publication) {
    if(t == publication->title()) {
        if(l == publication->language()) {
            if(n == publication->nature()) {
                return (c > publication->city());
            } return (n > publication->nature());
        } return (l > publication->language());
    } return (t > publication->title());
}

string Publication::hash() const {
    static int counter = 0;

    counter++;

    return to_string(counter);
}

}