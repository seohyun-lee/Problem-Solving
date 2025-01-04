
#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    int sumy=0, summ=0;
    while (n--) {
        int hour;
        cin >> hour;
        if (hour == 0) continue;
        sumy += ((hour / 30) + 1) * 10;
        summ += ((hour / 60) + 1) * 15;
    }
    if (sumy < summ)
        cout << "Y " << sumy;
    else if (sumy == summ)
        cout << "Y M " << sumy;
    else
        cout << "M " << summ;

    return 0;
}