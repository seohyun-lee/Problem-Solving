import java.io.*;
import java.util.*;

class Solution {
    static int parseTime(String a){
        return Integer.parseInt(a.split(":")[0])*60+Integer.parseInt(a.split(":")[1]);
    }
    static int normalize(int time){
        if(time>=24*60) time -= 24*60;
        return time;
    }
    static int compareTime(String[] a, String[] b){
        int aStartTime=parseTime(a[0]);
        int aEndTime=parseTime(a[1]);
        int bStartTime=parseTime(b[0]);
        int bEndTime=parseTime(b[1]);
        if(aStartTime==bStartTime) return aEndTime-bEndTime;
        return aStartTime-bStartTime;
    }
    
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> parseTime(a[0]) - parseTime(b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String[] book : book_time) {
            int start = parseTime(book[0]);
            int end = parseTime(book[1]) + 10;
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.offer(end);
        }
        return pq.size();
    }
}