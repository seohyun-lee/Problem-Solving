import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        long even = Arrays.stream(num_list).filter(n -> n % 2 == 0).count();
        long odd = num_list.length - even;
        return new int[]{(int)even, (int)odd};
    }
}
