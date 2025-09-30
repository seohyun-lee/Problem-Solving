import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        double ratio = D / Math.sqrt(H*H+W*W);
        double realH = H*ratio;
        double realW = W*ratio;
        System.out.println((int)realH+" "+(int)realW);
	}
}