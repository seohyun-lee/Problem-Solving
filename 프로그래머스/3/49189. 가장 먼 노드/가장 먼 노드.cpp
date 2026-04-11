#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;
bool visited[20001];

int solution(int n, vector<vector<int>> edge) {
    vector<vector<int>> graph(n+1);
    int contd=-1;
    int maxDistCnt=0;
    for(vector<int> v : edge){
        graph[v[0]].push_back(v[1]);
        graph[v[1]].push_back(v[0]);
    }
    queue<pair<int, int>> q;
    q.push({1, 0});
    visited[1]=true;
    while(!q.empty()){
        auto c=q.front(); 
        q.pop();
        if(contd!=c.second){
            contd=c.second;
            maxDistCnt=1;
        } else maxDistCnt++;
        for(int next : graph[c.first]){
            if(visited[next]==true) continue;
            visited[next]=true;
            q.push({next, c.second+1});
        }
    }
    return maxDistCnt;
}