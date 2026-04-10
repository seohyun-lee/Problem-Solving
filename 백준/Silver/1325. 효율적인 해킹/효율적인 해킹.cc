#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    vector<vector<int>> graph(n+1);
    for(int i=0; i<m; i++){
        int a, b;
        cin >> a >> b;
        graph[b].push_back(a); // b로인해 a로 가는걸 확인해야
    }
    //BFS
    int maxCnt=0;
    vector<int> comp;
    for(int i=1; i<=n; i++){
        queue<int> q;
        bool visited[n+1]={};
        int cnt=0;
        
        q.push(i);
        visited[i]=true;
        while(!q.empty()){
            int c=q.front();
            q.pop();
            for(int j : graph[c]){
                if(!visited[j]){
                    cnt++;
                    visited[j]=true;
                    q.push(j);
                }
            }
        }
        if(maxCnt==cnt) {
            comp.push_back(i);
        } else if(maxCnt<cnt){
            maxCnt=max(maxCnt,cnt);
            comp.assign(1, i);
        }
    }
    for(int c : comp)
        cout<<c<<" ";
    return 0;
}