#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

long long solution(int n, vector<int> works) {
    sort(works.begin(), works.end());
    reverse(works.begin(), works.end());
    
    for(int i=0; i<works.size()-1; i++) { // 5 2 1
        if(n<=0) break;
        if(works[i]==0) break;
        
        int diff = works[i]-works[i+1];
        if(diff==0) continue;
        int cnt=i+1;
        int rem = min(diff*cnt, n);
        // 앞에 애들 보기
        int a=rem%cnt;
        int b=rem/cnt;
        for(int i=0; i<cnt; i++){
            if(i<a) works[i]-=1;
            works[i]-=b;
        }
        n-=rem;
    }
    if(n>0){
        int len=works.size();
        int a=n%len;
        int b=n/len;
        for(int i=0; i<len; i++) {
            if(i<a) works[i]-=1;
            works[i]-=b;
        }
    }
    long long sum=0;
    for(int i=0; i<works.size(); i++) {
        if(works[i]<0) works[i]=0;
        sum+=works[i]*works[i];
    }
    return sum;
}