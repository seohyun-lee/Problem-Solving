import java.io.*;
import java.util.*;

public class Main {
	static class Node{
	    int value;
	    int index;
	    Node(int value, int index){
	        this.value = value;
	        this.index = index;
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    Deque<Node> dq = new LinkedList<>();
	    
		for(int i=0; i<n; i++) {
		    int now = Integer.parseInt(st.nextToken());
		    while(!dq.isEmpty() && dq.getLast().value > now) {
		        dq.removeLast();
		    }
		    dq.addLast(new Node(now, i));
		    if(dq.getFirst().index<= i-l) {
		        dq.removeFirst();
		    }
		    bw.write(dq.getFirst().value+" ");
		}
		bw.flush();
		bw.close();
	}
}