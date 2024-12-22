#include <iostream>
#include <string>
#include <unordered_map>

bool isIsomorphic(std::string s, std::string t) {
    if (s.size() != t.size()) return false;

    std::unordered_map<char, char> map_s_to_t;
    std::unordered_map<char, char> map_t_to_s;

    for (int i = 0; i < s.size(); ++i) {
        char c1 = s[i];
        char c2 = t[i];

        // Check if there is already a mapping for s[i] to t[i]
        if (map_s_to_t.find(c1) != map_s_to_t.end()) {
            if (map_s_to_t[c1] != c2) return false;
        } else {
            map_s_to_t[c1] = c2;
        }

        // Check if there is already a mapping for t[i] to s[i]
        if (map_t_to_s.find(c2) != map_t_to_s.end()) {
            if (map_t_to_s[c2] != c1) return false;
        } else {
            map_t_to_s[c2] = c1;
        }
    }

    return true;
}

int main() {
    std::string s = "badc";
    std::string t = "baba";

    if (isIsomorphic(s, t)) {
        std::cout << "The strings \"" << s << "\" and \"" << t << "\" are isomorphic." << std::endl;
    } else {
        std::cout << "The strings \"" << s << "\" and \"" << t << "\" are not isomorphic." << std::endl;
    }

    return 0;
}
