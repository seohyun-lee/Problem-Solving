#include <string>
#include <unordered_set>
#include <iostream>

using namespace std;

int solution(int N, int number) {
    unordered_set<int> s[9];
    int sum=0;
    for(int k=1; k<9; k++){
        sum=sum*10+N;
        s[k].insert(sum);
    }
    for(int k=2; k<9; k++){
        for(int i=1; i<k; i++){
            for(int a : s[i]){
                for(int b : s[k-i]){
                    s[k].insert(a+b);
                    s[k].insert(a-b);
                    s[k].insert(a*b);
                    if(b>0) {s[k].insert(a/b);}
                }
            }
            
        }
    }
    for(int k=1; k<9; k++){
        for(int a : s[k]){
            if(a==number){
                return k;
            }
        }
    }
    return -1;
}