#include <string>
#include <vector>
#include <queue>

using namespace std;

bool canConvert(const string& a, const string& b){
    int diff=0;
    for(int i=0; i<a.size(); i++) if(a[i]!=b[i]) diff++;
    return diff==1;
}


int solution(string begin, string target, vector<string> words) {
    bool hasTarget=false;
    for(auto& w:words) if(w==target) hasTarget=true;
    if(!hasTarget) return 0;
    
    //{현재단어, 단계수} <- pair<string, int>
    queue<pair<string, int>> q;
    vector<bool> visited(words.size(), false);
    q.push({begin, 0});
    while(!q.empty()){
        auto [curr, step]=q.front();
        q.pop();
        if(curr==target) return step;
        
        for(int i=0; i<words.size(); i++){
            if(!visited[i]&&canConvert(curr, words[i])){
                visited[i]=true;
                q.push({words[i], step+1});
            }
        }
    }
    return 0;
    
    return 0;
}