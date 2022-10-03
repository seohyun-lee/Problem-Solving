#include <iostream> //입출력을 위한 헤더
#include <deque> //자료구조 deque 사용 위한 헤더
using namespace std; //표준 라이브러리 사용

/**
 * [힌트] 벨트의 회전과 로봇의 이동을 인덱스로 관리해볼까요?
 * 1단계(rotate()): 벨트 회전 + n번째 칸 로봇 내리기
 * 2단계(move())  : 로봇 이동시키기 + n번째 칸 로봇 내리기
 * 3단계(put())   : 1번째 칸에 로봇 올리기
 */

struct info { //벨트 한 칸에 대해 내구도와 로봇 존재 여부를 같이 관리하기 위하여 구조체 info 사용
    int power;  //벨트 해당 칸의 내구도
    int robot;  //벨트 해당 칸 위 로봇 존재 여부(1: 존재O, 0: 존재X)
};

/** 1단계 */
void rotate(deque<info>& belt, int n) { //벨트를 회전시키고, n번째 칸 로봇 내리는 함수
    //벨트 회전
    belt.push_front(belt.back()); //벨트 칸 이동을 위해 맨 뒤의 값을 맨 앞에 삽입
    belt.pop_back(); //벨트 맨 뒤의 값 위치 이동되었으므로 맨 뒤의 값 삭제

    //n번째 칸 로봇 내리기
    if (belt[n - 1].robot) { //n번째 칸에 로봇이 존재할 경우
        belt[n - 1].robot--; //로봇 내리기
    }
}

/** 2단계 */
void move(deque<info>& belt, int n) { //로봇 이동시키기
    /*
    * [로봇 이동을 위한 조건]
    * 1. 현재 칸에 로봇이 존재하고(belt[i].robot)
    * 2. 다음 칸에 로봇이 존재하지 않고(!belt[i+1].robot)
    * 3. 다음 칸의 내구도가 1 이상일 때(belt[i].power)
    *
    * 이때 가장 먼저 올라간 로봇은 가장 뒤에 존재! -> 뒤에서부터 접근하기
    */

    int cur = n - 1, next;    //cur: 현재 칸, next: 다음 칸
    while (cur >= 0) {   //먼저 올라간 로봇부터 옮기기 시작, 끝부터 1번째 칸까지 체크
        next = (cur + 1) % (2 * n); //칸의 인덱스가 0~2n-1이므로 cur+1해준 뒤 %(2*n) 모듈러연산 수행
        if (belt[cur].robot && !belt[next].robot && belt[next].power) { //이동하려는 칸에 로봇이 없고 내구도가 1 이상이면 이동
            belt[cur].robot--; //현재 칸에 로봇이 없어지므로 belt[cur].robot은 1에서 0이 됨
            belt[next].robot++; //다음 칸에 로봇이 생기므로 belt[next].robot은 0에서 1이 됨
            belt[next].power--; //다음 칸의 내구도가 1 감소
        }
        cur--; //현재 칸보다 이전 칸 체크하기 위해 cur--
    }

    //n번째 칸 로봇 내리기
    if (belt[n - 1].robot) { //n번째 칸에 로봇이 존재할 경우
        belt[n - 1].robot--; //로봇 내리기
    }
}

/** 3단계 */
void put(deque<info>& belt) { //1번째 칸에 로봇 올리기
    if (belt[0].power) { //1번째 칸의 내구도가 1 이상이라면
        belt[0].robot++; //1번째 칸에 로봇 올리기
        belt[0].power--; //1번째 칸의 내구도 1 감소
    }
}

int countZero(deque<info>& belt, int n) { //벨트에서 내구도가 0인 칸 세기
    int cnt = 0; //내구도가 0인 칸 수를 셀 변수
    for (int i = 0; i < 2 * n; i++) { //1번째 칸부터 마지막 칸까지 확인
        if (belt[i].power == 0) { //i+1번째 칸의 내구도가 0이라면
            cnt++; //cnt를 1 증가시킨다
        }
    }
    return cnt; //cnt를 반환한다
}

int main() { //입출력 위한 메인 함수
    ios_base::sync_with_stdio(0); //c++ 입출력 속도 향상 코드
    cin.tie(0); //c++ 입출력 속도 향상 코드

    int n, k; //컨베이어 벨트의 길이 n과 내구도가 0인 칸의 개수 k 변수 선언
    cin >> n >> k; //n, k 입력받기
    deque<info> belt(2 * n, { 0,0 });    //벨트 초기화
    for (int i = 0; i < 2 * n; i++) { //벨트 칸수가 2n이니 2n번 반복
        cin >> belt[i].power; //벨트 i+1번째 칸의 내구도 입력 받기
    }

    int stage = 0;    //현재 진행 중인 단계
    do {
        rotate(belt, n); //벨트 회전
        move(belt, n); //로봇 이동
        put(belt); //로봇 올리기
        stage++; //stage번째 단계
    } while (countZero(belt, n) < k); //내구도가 0인 칸이 k개 미만인 동안 반복

    cout << stage; ///종료되었을 때 진행 중이었던 단계 출력

    return 0;
}