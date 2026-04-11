#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long solution(int n, vector<int> times) {
    long long lo = 1;
    long long hi = (long long)(*max_element(times.begin(), times.end()))*n;
    long long answer = hi;

    while (lo <= hi) {
        long long mid = (lo + hi) / 2;
        long long count = 0;
        for (int t : times) {
            count += mid / t;
            if (count >= n) break;
        }
        if (count >= n) {
            answer = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return answer;
}