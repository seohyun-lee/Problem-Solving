import java.io.*;
import java.util.*;

public class Main
{
    static class Pair{
        int m, v;
        Pair(int m, int v){
            this.m=m; this.v=v;
        }
    }
	    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] nk = br.readLine().split(" ");
	    int n=Integer.parseInt(nk[0]);
	    int k=Integer.parseInt(nk[1]);
	    long answer=0;
	    PriorityQueue<Pair> mvpq = new PriorityQueue<>(
	        (a, b) -> {
	            if(a.m==b.m) return Integer.compare(b.v, a.v); //가격 내림차순 
	            return Integer.compare(a.m, b.m); //무게 오름차순
	        }
	    );
	    Integer[] carr = new Integer[k];
	    // 지금까지 담을 수 있는 보석들 중 가장 가치 높은 것을 뽑기 위한 최대힙
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	    for(int i=0; i<n; i++){
	        String[] mv = br.readLine().split(" ");
    	    int m=Integer.parseInt(mv[0]);
    	    int v=Integer.parseInt(mv[1]);
	        mvpq.offer(new Pair(m, v));
	    }
	    for(int i=0; i<k; i++){
	        carr[i]=Integer.parseInt(br.readLine());
	    }
	    Arrays.sort(carr); // 가방 오름차순
	    for(int i=0; i<k; i++){
	        int bag=carr[i];
	        while(!mvpq.isEmpty() && mvpq.peek().m<=carr[i]){ //carr[i] 무게 이하의 보석 다 넣기
	            maxHeap.offer(mvpq.poll().v);
	        }
	        if(!maxHeap.isEmpty()) //비어있지 않으면 가장 가치가 큰 보석 담기
	            answer += maxHeap.poll();
	    }
		System.out.println(answer);
	}
}