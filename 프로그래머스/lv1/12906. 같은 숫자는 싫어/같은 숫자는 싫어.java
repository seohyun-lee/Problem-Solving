import java.util.*;
import java.util.Scanner;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int[] arr2 = new int[arr.length];
        arr2[0]+=arr[0];
        int index=0;
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=arr2[index]){
                index++;
                arr2[index]+=arr[i];
            }
        }
        answer = new int[index+1];
        for(int i=0; i<=index; i++){
            answer[i] = arr2[i];
        }
        return answer;
    }
}