import java.io.*;
import java.util.*;

public class Main
{
    static int n, m;
    static int[][] A;
    static int[][] chis, hous, dist;
    static int hCnt, cCnt;
    static int min = Integer.MAX_VALUE;
    static boolean[] selected;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][n];
        hCnt = 0; cCnt = 0;
        
        int cIdx = 0, hIdx = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){ 
                A[i][j] = Integer.parseInt(st.nextToken());
                // 치킨집
                if(A[i][j]==2){
                    cCnt++;
                } else if (A[i][j]==1){
                    hCnt++;
                }
            }
        }
        
        chis = new int[cCnt][2];
        hous = new int[hCnt][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){ 
                if(A[i][j]==2){
                    chis[cIdx][0]=i; chis[cIdx][1]=j;
                    cIdx++;
                } else if (A[i][j]==1){
                    hous[hIdx][0]=i; hous[hIdx][1]=j;
                    hIdx++;
                }
            }
        }
        dist = new int[hCnt][cCnt];
        
        for(int i=0; i<hCnt; i++){
            for(int j=0; j<cCnt; j++){
                dist[i][j] = Math.abs(hous[i][0]-chis[j][0]) + Math.abs(hous[i][1]-chis[j][1]);
            }
        }
        
        selected = new boolean[cCnt];
        comb(0, 0);
        System.out.println(min);

	}
	
	static void comb(int depth, int start){
	    if(depth==m){
	        int total=0;
	        for(int i=0; i<hCnt; i++){
	            int d=Integer.MAX_VALUE;
	            for(int j=0; j<cCnt; j++){
	                if(selected[j]) d=Math.min(d, dist[i][j]);
	            }
	            total+=d;
	        }
	        min=Math.min(min, total);
	        return;
	    }
	    for(int i=start; i<cCnt; i++){
	        selected[i]=true;
	        comb(depth+1, i+1);
	        selected[i]=false;
	    }
	}
	
}