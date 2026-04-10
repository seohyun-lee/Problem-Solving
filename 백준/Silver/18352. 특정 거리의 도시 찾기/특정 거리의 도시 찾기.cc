#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int dist[300001];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n, m, k, x;
    cin >> n >> m >> k >> x;
    vector<int> v[n+1];
    for(int i=0; i<m; i++){
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
    }
    vector<int> q;
    dist[x]=-1;
    q.push_back(x);
    for(int i=1; i<=k; i++){
        vector<int> q2;
        while(!q.empty()){
            int curr = q.front();
            q.erase(q.begin());
            for(int j : v[curr]){
                if(dist[j]==0) {
                    dist[j]=i;
                    q2.push_back(j);
                }
            }
        }
        q=q2;
    }
    if (q.empty()) cout << -1;
    sort(q.begin(), q.end());
    while(!q.empty()) {
        int a = q.front();
        if(dist[a]!=0) {
            cout<< a << "\n";
            dist[a]=0;
        }
        q.erase(q.begin());
    }
}