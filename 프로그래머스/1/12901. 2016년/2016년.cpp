#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    string dayOfTheWeek[7]={"SUN","MON","TUE","WED","THU","FRI","SAT"};
    int days[12]={31,29,31,30,31,30,31,31,30,31,30,31};
    int idx=4;
    for(int i=0;i<a-1;i++){
        idx+=days[i];
    }
    return dayOfTheWeek[(idx+b)%7];
}