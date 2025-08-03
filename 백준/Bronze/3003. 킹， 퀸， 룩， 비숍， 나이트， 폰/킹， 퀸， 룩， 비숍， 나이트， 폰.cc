#include <iostream>
using namespace std;

int main()
{
    int chess[16] = {1, 1, 2, 2, 2, 8};
    for(int i=0; i<6; i++) {
        int a;
        cin >> a;
        cout << chess[i]-a << " ";
    }
    return 0;
}