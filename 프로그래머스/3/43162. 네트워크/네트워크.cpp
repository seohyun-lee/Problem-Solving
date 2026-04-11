#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(int n, vector<vector<int>> computers) {
    // computers는 인접행렬인데 이걸 인접리스트처럼 생각해서 (0이아닌경우 j를꺼냄) 타고타고가기
    int answer = 0;
    bool visited[201]={};
    for(int i=0; i<n; i++){
        if(visited[i]) continue;
        answer++;
        queue<int> q;
        q.push(i);
        visited[i]=true;
        while(!q.empty()){
            int c=q.front();
            q.pop();
            for(int j=0; j<n; j++){
                if(computers[c][j]==1 && !visited[j]) { // i->j
                    visited[j]=true;
                    q.push(j);
                }
            }
        }
    }
    return answer;
}