#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<bool> v(31);
    for (int i=1; i<=28; i++) {
        int p;
        cin >> p;
        v[p] = 1;
    }
    int minf = 30;
    int mins = 30;
    for (int i=1; i<=28; i++) {
        if (v[i] == 0) {
            int p = i;
            if (mins > p) {
                if (minf > p){
                    mins = minf;
                    minf = p;
                }
                else
                    mins = p;
            }
        }
    }
    cout << minf << "\n" << mins;
}