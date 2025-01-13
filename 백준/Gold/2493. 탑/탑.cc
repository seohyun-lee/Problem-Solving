/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <stack>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    stack<pair<int, int>> S;
    for (int i=1; i<=n; i++) {
        int tower;
        cin >> tower;
        if (S.empty()) {
            cout << "0 ";
        } else if (S.top().first >= tower) {
            cout << S.top().second << " ";
        } else {
            while (!S.empty() && S.top().first < tower) {
                S.pop();
            }
            if (S.empty()) {
                cout << "0 ";
            } else {
                cout << S.top().second << " ";
            }
        }
        S.push({tower, i});
    }
}