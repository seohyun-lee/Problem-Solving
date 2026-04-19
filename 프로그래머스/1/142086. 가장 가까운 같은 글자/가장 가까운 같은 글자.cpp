#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(string s) {
    int alpha[26];
    fill(alpha, alpha+26, -1);
    vector<int> answer(s.length());
    for(int i=0; i<s.length(); i++){
        char c = s[i]-'a';
        if(alpha[c]==-1) answer[i]=-1;
        else answer[i]=i-alpha[c];
        alpha[c]=i;
    }
    return answer;
}