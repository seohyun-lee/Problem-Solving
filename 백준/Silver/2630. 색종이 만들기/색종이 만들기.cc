#include <iostream>
using namespace std;

int p[128][128];
int cnt[2];

void check(int w, int a, int b) {
    if (w == 1) {
        cnt[p[a][b]]++;
        return;
    }
    int start = p[a][b];
    bool flag = true;
    for (int i=0; i<w; i++) {
        for (int j=0; j<w; j++) {
            if (start != p[a+i][b+j]) {
                flag = false;
                break;
            }
        }
        if (flag == false)
            break;
    }
    if (flag == false) {
        for (int k=0; k<2*2; k++) {
            check(w/2, (k/2)*(w/2)+a, (k%2)*(w/2)+b);
        }
    } else {
        cnt[p[a][b]]++;
        return;
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            cin >> p[i][j];
        }
    }
    check(n, 0, 0);
    cout << cnt[0] << "\n" << cnt[1];
}