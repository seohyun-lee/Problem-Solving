#include <vector>
#include <string>
#include <iostream>

using namespace std;

int calc(vector<string> arr, int start, int end, bool bigger){
    if(start==end)
        return stoi(arr[start]);

    int sum;
    if (bigger) sum = -2100000000;
    else sum = 2100000000;
    
    for(int m=start+1; m<end; m+=2){
        int res=0;
        if(arr[m]=="+"){
           res = calc(arr, start, m-1, true) + calc(arr, m+1, end, true);
        } else{
           res = calc(arr, start, m-1, true) - calc(arr, m+1, end, false);
        }
        if (bigger) sum = max(sum, res);
        else sum = min(sum, res);
    }
    return sum;
}

int solution(vector<string> arr)
{
    int answer = -1;
    int len = arr.size();
    return calc(arr, 0, len-1, true);
}