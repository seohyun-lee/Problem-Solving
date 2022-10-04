#include <iostream> // 입출력을 위한 헤더
#include <deque> // 자료구조 deque 사용 위한 헤더

using namespace std; // 표준 라이브러리를 사용
// src의 합치는 카드 더미를 des의 카드 더미로 합치는 함수
void mergeCards(deque<int>& src, deque<int>& des) // 카드 더미 합치기 함수
{
    while (!src.empty()) // src카드 더미에 값이 존재하는 동안 실행. 즉 des로 카드를 다 옮길 때까지
    {
        des.push_back(src.back()); // 상대방 덱을 뒤집어서(맨 아랫장부터=src.back() 맨 뒤부터) des 아래에 넣기
        src.pop_back(); // des에 합친 카드는 src에서 제거
    }
}
string playGame(int m, deque<int>& dodo, deque<int>& su) //게임 진행 함수
{
    deque<int> do_gr; // 그라운드에 있는 도도의 카드 더미
    deque<int> su_gr; // 그라운드에 있는 수연의 카드 더미
    bool flag = true; // true일 때는 도도의 차례, false 일 때는  수연의 차례
    while (m--) // m턴 실행
    {
        if (flag) // 도도의 차례
        {
            do_gr.push_front(dodo.front()); // 덱에 있는 맨 위의 카드를 그라운드에 놓는다.front=위, back=아래 개념.
            dodo.pop_front(); // 도도 덱의 맨 위의 카드 제거
            if (dodo.empty()) { // 도도 덱의 카드 수가 0이라면
                return "su"; // 덱에 있는 카드의 수가 0이 되면 상대방이 즉시 승리. 수연이가 즉시 승리
            }
        }
        else // 수연의 차례
        {
            su_gr.push_front(su.front()); /// 덱에 있는 맨 위의 카드를 그라운드에 놓는다
            su.pop_front(); // 수연 덱의 맨 위의 카드 제거
            if (su.empty()) { // 수연 덱의 카드 수가 0이라면
                return "do"; // 덱에 있는 카드의 수가 0이 되면 상대방이 즉시 승리. 도도가 즉시 승리
            }
        }
        flag = !flag; // 순서 바꾸기
        // 도도와 수연이가 종을 칠 수 있는지 검사
        // 도도가 종을 쳤을 때
        if (!do_gr.empty() && do_gr.front() == 5 || !su_gr.empty() && su_gr.front() == 5) { // 도도의 그라운드에 카드가 있으며 맨 위 카드의 숫자가 5거나 수연의 그라운드에 카드가 있으며 맨 위 카드의 숫자가 5라면
            mergeCards(su_gr, dodo); // 수연(상대방)의 그라운드 카드더미부터 도도의 덱에 합침
            mergeCards(do_gr, dodo); // 도도의 그라운드 카드더미를 도도의 덱에 합침
        }
        // 수현이가 종을 쳤을 때
        if (!do_gr.empty() && !su_gr.empty() && do_gr.front() + su_gr.front() == 5) { // 도도의 그라운드와 수연의 그라운드에 모두 카드가 있으며 각각의 맨 위 카드 숫자의 합이 5인 경우
            mergeCards(do_gr, su); // 도도(상대방)의 그라운드 카드더미부터 수연의 덱에 합침
            mergeCards(su_gr, su); // 수연의 그라운드 카드더미를 수연의 덱에 합침
        }
    }
    // m턴 실행 완료 시 탈출됨
    if (dodo.size() > su.size()) { // 도도 덱의 카드수가 수연 덱의 카드수보다 많으면
        return "do";
    }
    else if (dodo.size() < su.size()) { // 수연 덱의 카드수가 도도 덱의 카드수보다 많으면
        return "su";
    }
    return "dosu"; // 위의 두 가지 경우에 해당되지 않으면 카드 수가 같다는 뜻. 무승부
}
/*
 *[숫자 할리갈리 게임] : 구현, 시뮬레이션
 * 도도,수연이의 덱과 그라운드에 있는 도도,수연의 덱 총 4개의 덱을 관리해주면 됩니다
 * deque 라이브러리를 사용하면 카드 덱에서 일어나는 일들을 쉽게 구현할 수 있습니다
 * 문제에서 주어진 게임 진행 순서대로 구현하면 됩니다
 * 게임 순서와 종료 조건을 주의하셔야 합니다
 */
int main() // 입출력 위한 메인 함수
{
    int n, m; // 카드 갯수 n, 게임 진행 횟수 m 정수형 변수 선언
    cin >> n >> m; // n, m에 저장될 값 차례로 입력받기
    deque<int> dodo; // 도도 덱 deque로 선언
    deque<int> su; // 수연 덱 deque로 선언
    for (int i = 0; i < n; i++) // 카드 갯수 각각 n개씩, 도도와 수연의 초기 카드 덱 구성 입력받기
    {
        int a, b; // 카드 숫자 저장할 변수 a, b
        cin >> a >> b; // 도도, 수연순서로 카드 숫자 입력받기
        dodo.push_front(a); // 도도 덱 맨 위에 카드 추가
        su.push_front(b); // 수연 덱 맨 위에 카드 추가
    }
    cout << playGame(m, dodo, su); // 게임 진행 함수 실행하고 승부 결과 출력
    return 0; // 메인 함수 종료
}