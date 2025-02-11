#include <bits/stdc++.h>
using namespace std;


int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
    
  int n;
  cin >> n;
  int d[1010] = {0, 1, 3, };
  int mod = 10007;
  for(int i = 3; i <= n; ++i)
    d[i] = (d[i-1] + d[i-2] * 2) % mod;
  cout << d[n];
}