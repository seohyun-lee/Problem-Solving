import java.io.*;
import java.util.*;

public class Main
{
    private static int n;
    private static List<List<Node>> graph;
    
    private static class Node implements Comparable<Node> {
        int index, weight;
        Node(int index, int weight) { this.index = index; this.weight = weight; }
        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.weight, n.weight);
        } 
    }
    
    private static int[] dijkstraForFox(){
	    int[] distance = new int[n]; // [노드]
	    Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
	    distance[0] = 0; // 시작점은 0
        pq.add(new int[]{0, 0}); // 점, 가중치
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int currDist = curr[1];
            if(currDist > distance[u])
                continue;
            for(Node n : graph.get(u)) {
                int v = n.index;
                int w = n.weight;
                if(curr[1] + w < distance[v]){
                    distance[v] = curr[1] + w;
                    pq.add(new int[]{v, distance[v]});
                }
            }
        }
        return distance;
    }
    
    private static int[][] dijkstraForWolf(){
	    int[][] distance = new int[n][2]; // [노드][상태], 0=빠름, 1=느림
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
	    distance[0][0] = 0; // 시작점은 0
        pq.add(new int[]{0, 0, 0}); // 점, 가중치, 상태
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int currDist = curr[1];
            int state = curr[2];
            if (currDist > distance[u][state])
                continue;
            for (Node n : graph.get(u)) {
                int v = n.index;
                int w = state == 1 ? n.weight * 2 : n.weight / 2;
                int nextState = 1 - state;
                if (currDist + w < distance[v][nextState]) {
                    distance[v][nextState] = currDist + w;
                    pq.add(new int[]{v, distance[v][nextState], nextState});
                }
            }
        }
        return distance;
    }
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    graph = new ArrayList<>();
	    for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
	    }
	    for(int i=0; i<m; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int d = Integer.parseInt(st.nextToken())*2; // /2 고려
	        graph.get(a-1).add(new Node(b-1, d));
	        graph.get(b-1).add(new Node(a-1, d));
	    }
	    int[] dFox = dijkstraForFox();
	    int[][] dWolf = dijkstraForWolf();
	    int count = 0;
	    for(int i=0; i<n; i++) {
	        if (dFox[i] < dWolf[i][0] && dFox[i] < dWolf[i][1]) count++;
	    }
	    System.out.println(count);
	}
}