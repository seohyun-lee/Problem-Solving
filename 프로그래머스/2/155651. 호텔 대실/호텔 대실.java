import java.io.*;
import java.util.*;

class Solution {
    static int parseTime(String a){
        return Integer.parseInt(a.split(":")[0])*60+Integer.parseInt(a.split(":")[1]);
    }
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(book_time, (a, b) -> parseTime(a[0]) - parseTime(b[0]));
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
