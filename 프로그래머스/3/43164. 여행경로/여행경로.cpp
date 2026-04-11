#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;
int n;
vector<string> answer; // 외부에 저장

bool dfs(string cur, map<string, vector<string>>& graph, map<string, vector<bool>>& used, vector<string> path){
    if((int)path.size()==n+1){
        answer=path;
        return true;
    }
    
    if(graph.find(cur)==graph.end()) //graph[cur]를 바로쓰면 자동 생성되는 문제 방지
        return false;
    
    for(int i=0; i<(int)graph[cur].size(); i++){
        if(!used[cur][i]){
            // 쓰기
            used[cur][i]=true;
            path.push_back(graph[cur][i]);
            if(dfs(graph[cur][i], graph, used, path)) // 돌리기 및 탈출(1가지 경우만 필요하므로)
                return true; 
            // 원복
            used[cur][i]=false;
            path.pop_back();
        }
    }
    return false;
}

vector<string> solution(vector<vector<string>> tickets) {
    n=tickets.size();
    map<string, vector<string>> graph; //출발지->도착지
    map<string, vector<bool>> used;
    
    sort(tickets.begin(), tickets.end());
    for(auto& t: tickets){
        graph[t[0]].push_back(t[1]);
        used[t[0]].push_back(false);
    }
    dfs("ICN", graph, used, {"ICN"});
    return answer;
}