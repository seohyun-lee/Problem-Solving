
#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    int SIZE=10001;
    int num[SIZE]={0,};
    
    cin >> n;
    for (int i=0; i<n; i++) {
        int k;
        cin >> k;
        num[k]++;
    }
    for (int i=0; i<SIZE; i++) {
        while (num[i] > 0) {
            cout << i << "\n";
            num[i]--;
        }
    }
}