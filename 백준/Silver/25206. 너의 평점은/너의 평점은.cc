#include <iostream>
using namespace std;

double calcGrade(string& grade) {
    double sum=0;
    
    if(grade[0] == 'A') sum += 4;
    else if(grade[0] == 'B') sum += 3;
    else if(grade[0] == 'C') sum += 2;
    else if(grade[0] == 'D') sum += 1;
    
    if(grade.size() > 1 && grade[1] == '+') sum += 0.5;
    return sum;
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    double avgGpa = 0;
    double clsSum = 0;
    for (int i=0; i<20; i++) {
        string sub, grade;
        double cls;
        cin >> sub >> cls >> grade;
        if (grade != "P")
            clsSum += cls;
        avgGpa += cls * calcGrade(grade);
    }
    printf("%.6f", avgGpa / clsSum);
}