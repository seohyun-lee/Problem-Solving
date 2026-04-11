#include <string>
#include <vector>

using namespace std;

vector<vector<int>> rotate(vector<vector<int>> &key, int& M){
    vector<vector<int>> newKey(M, vector<int>(M, 0)); // 2차원 벡터 초기화
    for(int i=0; i<M; i++){
        for(int j=0; j<M; j++){
            newKey[j][M-1-i]=key[i][j];
        }
    }
    return newKey;
}

bool check(vector<vector<int>>& key, vector<vector<int>>& lock, int& dy, int& dx, int& M, int& N){
    // lock 전체를 순회하며 모든 홈(0)이 채워졌는지 확인
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int ky = i - dy;
            int kx = j - dx;
            int keyVal = (ky >= 0 && ky < M && kx >= 0 && kx < M) ? key[ky][kx] : 0;
            if (keyVal == 1 && lock[i][j] == 1) return false; // 돌기 충돌
            if (keyVal == 0 && lock[i][j] == 0) return false; // 홈 못채움
        }
    }
    return true;
}


bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    int M=key.size();
    int N=lock.size(); // lock 좌표: (0,0)~(N,N)
    //key 시작 좌표 가능 범위
    int start=-M+1, end=N-1;
    // 4번 회전
    for(int r=0; r<4; r++){
        for(int dy=start; dy<=end; dy++){
            for(int dx=start; dx<=end; dx++){
                if(check(key, lock, dy, dx, M, N)) return true;
            }
        }
        key = rotate(key, M);
    }
    return false;
}