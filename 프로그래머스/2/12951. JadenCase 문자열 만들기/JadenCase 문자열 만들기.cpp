#include <string>

using namespace std;

string solution(string s) {
    for (int i=0; i<s.length(); i++) {
        if(s[i] >= 'a' && s[i] <= 'z' && (i == 0 || s[i-1] == ' ')) {
            s[i] -= ('a' - 'A');
        } else if (s[i] >= 'A' && s[i] <= 'Z' && !(i == 0 || s[i-1] == ' ')) {
            s[i] += ('a' - 'A');
        }
    }
    return s;
}
