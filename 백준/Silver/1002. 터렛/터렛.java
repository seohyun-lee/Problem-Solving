import java.io.*;
import java.util.*;

public class Main
{
    static int T;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            System.out.println(calc(x1, y1, x2, y2, r1, r2));
        }
	}
	static int calc(int x1, int y1, int x2, int y2, int r1, int r2){
	    double centerDist = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	    
	    if (centerDist==0 && r1==r2) return -1;
	    else if (centerDist==Math.abs(r1-r2) || centerDist==r1+r2) return 1;
	    else if (Math.abs(r1-r2) <= centerDist && centerDist <= r1+r2) return 2;
	    else return 0;
	}
}