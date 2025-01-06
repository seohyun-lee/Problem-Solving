#include<iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int a, b, c;
    int num[10]={0,};
    
    cin >> a >> b >> c;
    long long res = a * b * c;
    while(res > 0){
        int v = res % 10;
        num[v]++;
        res /= 10;
    }
    for(int i=0; i<10; i++){
        cout << num[i] << "\n";
    }
}