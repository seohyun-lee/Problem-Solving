#include <vector>
#include <unordered_set>
using namespace std;

int solution(vector<int> nums)
{
    unordered_set<int> s;
    for(int i : nums) 
        s.insert(i);
    return min(s.size(), nums.size()/2);
}