#include <string>
#include <vector>
#include <set>
using namespace std;

vector<int> solution(vector<string> operations) {
    multiset<int> ms;
    for(string op: operations){
        if(op[0]=='I') {
            ms.insert(stoi(op.substr(2)));
        } else if(op == "D 1") {
            if(!ms.empty()) ms.erase(prev(ms.end()));
        } else {
            if(!ms.empty()) ms.erase(ms.begin());
        }
    }
    if(ms.empty()) return {0, 0};
    else return {*prev(ms.end()), *ms.begin()};
}