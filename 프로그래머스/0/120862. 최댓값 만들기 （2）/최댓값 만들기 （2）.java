import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        int a = numbers[0]*numbers[1];
        int b = numbers[n-1]*numbers[n-2];
        return a > b ? a : b;
    }
}