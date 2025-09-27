import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int layers = Math.min(N, M) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int r1 = layer;
            int c1 = layer;
            int r2 = N - 1 - layer;
            int c2 = M - 1 - layer;

            List<Integer> list = new ArrayList<>();
            // 한 겹 뽑기 (위->오른->아래->왼)
            for (int c = c1; c <= c2; c++) 
                list.add(arr[r1][c]);
            for (int r = r1 + 1; r <= r2 - 1; r++) 
                list.add(arr[r][c2]);
            for (int c = c2; c >= c1; c--) 
                list.add(arr[r2][c]);
            for (int r = r2 - 1; r >= r1 + 1; r--) 
                list.add(arr[r][c1]);

            int len = list.size();
            int rot = R % len;

            // 리스트에 넣었던 것과 같은 순서로 돌며 채우기
            int idx = 0;
            for (int c = c1; c <= c2; c++) 
                arr[r1][c] = list.get((idx++ + rot) % len);
            for (int r = r1 + 1; r <= r2 - 1; r++) 
                arr[r][c2] = list.get((idx++ + rot) % len);
            for (int c = c2; c >= c1; c--)  
                arr[r2][c] = list.get((idx++ + rot) % len);
            for (int r = r2 - 1; r >= r1 + 1; r--) 
                arr[r][c1] = list.get((idx++ + rot) % len);
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int v : row) 
                sb.append(v).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
