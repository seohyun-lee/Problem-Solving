#include <iostream>
#include <string>
using namespace std;

int solution(string s)
{
    int answer=1;
    int n=s.length();
    for(int i=0; i<n; i++){
        int len=1;
        while(i-len>=0&&i+len<n){
            if(s[i-len]==s[i+len]){
                answer=max(answer,1+len*2);
                len++;
            } else break;
        }
        len=0;
        while(i-len>=0&&i+1+len<n){
            if(s[i-len]==s[i+1+len]){
                answer=max(answer,2+len*2);
                len++;
            } else break;
        }
    }
    return answer;
}