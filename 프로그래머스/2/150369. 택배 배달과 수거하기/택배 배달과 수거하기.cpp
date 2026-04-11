#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = 0;
    int end=n-1;
    while(end>=0){
        // end 조절하기
        while(end>=0&&deliveries[end]==0&&pickups[end]==0) end--;
        if(end<0) break;
        
        answer+=(end+1)*2;
        
        int dCap=cap, pCap=cap;
        for(int i=end; i>=0&&dCap>0; i--){
            if(deliveries[i]==0) continue;
            int diff=min(dCap, deliveries[i]);
            dCap-=diff;
            deliveries[i]-=diff;
        }
        for(int i=end; i>=0&&pCap>0; i--){
            if(pickups[i]==0) continue;
            int diff=min(pCap, pickups[i]);
            pCap-=diff;
            pickups[i]-=diff;
        }
    }
    return answer;
}