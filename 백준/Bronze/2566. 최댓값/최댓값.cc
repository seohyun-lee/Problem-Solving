#include <iostream>
using namespace std;

int main()
{
    int maxNum=-1, x=0, y=0;
    for(int i=1; i<=9; i++) {
        for(int j=1; j<=9; j++) {
            int a;
            cin >> a;
            if(a>maxNum) {
                x=i;
                y=j;
                maxNum=a;
            }
        }
    }
    cout << maxNum << "\n" << x << " " << y;
    return 0;
}