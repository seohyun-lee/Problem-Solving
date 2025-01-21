#include <iostream>
using namespace std;

int p[2187][2187] = {0,};
int cnt[3] = {0,};

void check(int w, int a, int b) {
    if (w == 1) {
        cnt[p[a][b]+1]++;
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
        int nw = w/3;
        for (int k=0; k<9; k++) {
            check(nw, (k/3)*nw+a, (k%3)*nw+b);
        }
    } else {
        cnt[p[a][b]+1]++;
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
    cout << cnt[0] << "\n" << cnt[1] << "\n" << cnt[2];
}