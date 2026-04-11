#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int s) {
    vector<int> answer;
    if(s<n){
        return {-1};
    } else {
        int a=s/n;
        int b=s%n;
        for(int i=n-1; i>=0; i--){
            if(i<b) answer.push_back(a+1);
            else answer.push_back(a);
        }
    }
    return answer;
}