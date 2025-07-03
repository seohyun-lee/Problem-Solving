import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0; // i: 앞 인덱스
        for(int j = people.length - 1; i < j; j--) { // j: 뒤 인덱스
            if (people[i] + people[j] <= limit)
                i++;
        }
        return people.length-i; // i명이 '같이 승차'
    }
}