#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    while(true) {
        int t[3];
        cin >> t[0] >> t[1] >> t[2];
        if (t[0] == 0)
            break;
        sort(t, t+3);
        if (t[2] >= t[0] + t[1])
            cout << "Invalid\n";
        else {
            if (t[0] == t[1]) {
                if (t[1] == t[2])
                    cout << "Equilateral\n";
                else
                    cout << "Isosceles\n";
            } else {
                if (t[0] == t[2] || t[1] == t[2])
                    cout << "Isosceles\n";
                else
                    cout << "Scalene\n";
            }
        }
    }
}