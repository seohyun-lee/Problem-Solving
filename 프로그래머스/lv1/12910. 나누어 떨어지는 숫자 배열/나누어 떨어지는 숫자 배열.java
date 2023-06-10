import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        int cnt=0;
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                cnt++;
            }
        }
        if(cnt==0){
            answer=new int[1];
            answer[0]=-1;
            return answer;
        }
        
        answer = new int[cnt];
        int index=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                answer[index]+=arr[i];
                index++;
            }
        }
        return answer;
    }
}