#include <string>
#include <vector>
#include <set>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    multiset<string> ms;
    for(string s : participant) ms.insert(s);
    for(string s : completion) ms.erase(ms.find(s));
    return *ms.begin();
}