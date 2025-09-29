import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        
        int[] minCntList = new int[4];
        int[] currCntList = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int k=0; k<4; k++){
            minCntList[k] = Integer.parseInt(st.nextToken());
        }
        
        int availableCnt=0;
        for(int i=0; i<s; i++){
            currCntList[baseCharToIndex(dna.charAt(i))]++;
            if(i>=p-1){
                if(i>=p)
                    currCntList[baseCharToIndex(dna.charAt(i-p))]--;
                boolean flag=true;
                for(int k=0; k<4; k++){
                    if(minCntList[k]>currCntList[k]) {
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    availableCnt++;
                }
            }
        }
        System.out.println(availableCnt);
	}
	static int baseCharToIndex(char c){
	    if(c=='A') return 0;
	    else if(c=='C') return 1;
	    else if(c=='G') return 2;
	    else return 3;
	}
}