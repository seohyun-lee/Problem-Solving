#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool check(vector<vector<int>> graph, int v){
    int visited[v+1];
    fill(visited, visited+v+1, 0);
    
    for(int i=0; i<v; i++){
        queue<int> q;
        q.push(i);
        
        if(visited[i]==0) visited[i]=1;
        while(!q.empty()){
            int c=q.front();
            q.pop();
            for(int j : graph[c]){
                if(visited[j]==0) {
                    q.push(j);
                    visited[j]=3-visited[c];
                }if(visited[j]==visited[c]) {
                    return false;
                }
            }
        }
    }
    return true;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int tk, v, e;
    cin>>tk;
    while(tk-->0){
        cin>>v>>e;
        vector<vector<int>> graph(v+1);
        for(int i=0; i<e; i++){
            int a, b;
            cin>>a>>b;
            graph[a].push_back(b);
            graph[b].push_back(a);
        }
        if(check(graph, v))
            cout<<"YES\n";
        else    
            cout<<"NO\n";
    }
}