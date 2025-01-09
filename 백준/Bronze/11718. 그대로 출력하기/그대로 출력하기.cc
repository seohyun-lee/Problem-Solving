#include <iostream>
#include <string>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    string line;
    while (getline(cin, line))
        cout << line << "\n";
    return 0;
}