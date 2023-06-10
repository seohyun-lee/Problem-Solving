class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n); //Long 클래스로 n을 String으로 s에 넣음(12345)
        String[] arr= s.split(""); //String class의 split 메소드임. s를 글자단위로 쪼개어 배열에 넣을 수 있음.
        int[] answer = new int[s.length()]; //answer배열을 s의 길이만큼의 크기로생성
        
        for(int i=0; i<s.length(); i++){ //i를 s.lenth번 반복
            answer[i] = Integer.valueOf(arr[s.length()-i-1]); //answer[i];에 arr 젤 오른쪽끝 값부터.... 이때 값을 Interger클래스의 valueOf메소드를 사용해서 바꿔주기
        }
        
        return answer;
    }
}