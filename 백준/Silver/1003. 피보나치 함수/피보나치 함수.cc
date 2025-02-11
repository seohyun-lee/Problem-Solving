#include <bits/stdc++.h>
using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int fibo[42][2] = {0,};
  fibo[0][0] = 1;
  fibo[1][1] = 1;
  for (int i = 2; i <= 40; i++) {
    fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
    fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
  }
  int T;
  cin >> T;
  while (T--) {
    int N;
    cin >> N;
    cout << fibo[N][0] << " " << fibo[N][1] << endl;
  }
}