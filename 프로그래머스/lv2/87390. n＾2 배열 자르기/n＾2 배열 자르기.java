class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int k =0;
        long row;
        long column;
        for(long i = left; i<= right; i++){
            row = i/n;
            column = i%n;
            if(row>column)
                answer[k] = (int)row+1;
            else
                answer[k] = (int)column+1;
            k++;
        }
        return answer;
    }
}