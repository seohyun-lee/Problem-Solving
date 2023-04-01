import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
	    int[] tempArray;
	    for(int i=0; i<commands.length; i++) {
	    	tempArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
	    	Arrays.sort(tempArray);
	    	answer[i] = tempArray[commands[i][2]-1];
	    }
	    return answer;
    }
}