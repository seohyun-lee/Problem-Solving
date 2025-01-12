
#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int k, n;
    cin >> n >> k;
    list<int> L;
    
    for (int i = 1; i <= n; i++) {
        L.push_back(i);
    }
    
    cout << "<";
    auto t = L.begin(); // 처음에 1을 가리킴
    for (int i=1; i<=n; i++) {
        for (int j=1; j<k; j++){ // k-1번 반복해야 함
            t++;
            if (t == L.end()) t = L.begin();
        }
        cout << *t;
        if (i != n)
            cout << ", ";
        t = L.erase(t); // 삭제된 요소의 다음 반복자가 반환됨
        if (t == L.end()) t = L.begin(); 
    }
    cout << ">";
}