#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    int cnt=0;
    int i=B.size()-1;
    int j=i;
    while(i>=0&&j>=0){
        if(B[i]>A[j]) { cnt++; i--; j--; }
        else j--;
    }
    return cnt;
}