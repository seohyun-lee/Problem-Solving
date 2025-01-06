#include<bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    int num[9]={0,};
    cin >> n;
    while(n > 0){
        int v = n%10;
        if (v==9)
            num[6]++;
        else
            num[v]++;
        n/=10;
    }
    int max=0;
    for (int i=0; i<9; i++) {
        if(i==6){
            if(max<(num[i]+1)/2) max=(num[i]+1)/2;
        } else {
            if(max<num[i]) max=num[i];
        }
    }
    cout << max;
}