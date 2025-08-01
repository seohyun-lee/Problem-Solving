import java.io.*;
import java.util.*;

public class Main
{
    static int[][] arr = new int[100][100];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int r = Integer.parseInt(s[0])-1;
        int c = Integer.parseInt(s[1])-1;
        int k = Integer.parseInt(s[2]);
        // List<List<Integer>> arr = new ArrayList<>();
        // for (int i=0; i<3; i++) {
        //     arr.add(new ArrayList<>());
        // } 
        for(int i=0; i<3; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int rowLength = 3;
        int colLength = 3;
        int count=0;
        while(count <= 100) {
            if(arr[r][c]==k){
                System.out.println(count);
                return;
            }
            // r연산
            if (rowLength >= colLength) {
                int newColLength = 0;
                for (int i=0; i<rowLength; i++) {
                    Arrays.sort(arr[i], 0, colLength);
                    List<int[]> countList = new ArrayList<>();
                    int cnt=1;
                    for(int j=0; j<colLength; j++) {
                        if(arr[i][j] == 0) continue;
                        if (j != colLength-1 && arr[i][j] == arr[i][j+1]) {
                            cnt++;
                        } else {
                            countList.add(new int[]{arr[i][j], cnt});
                            cnt = 1;
                        }
                    }
                    countList.sort((a, b) -> {
                        if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                        return Integer.compare(a[0], b[0]);
                    });
                    int j=0;
                    int localColLength = 0;
                    for (int[] pair : countList) {
                        if (j>=100) break;
                        arr[i][j++] = pair[0];
                        if (j>=100) break;
                        arr[i][j++] = pair[1];
                        localColLength+=2;
                    }
                    if (newColLength < localColLength)
                        newColLength = localColLength;
                    for(; j<100; j++) {
                        arr[i][j] = 0;
                    }
                }
                colLength = newColLength;
            }
            // c연산
            else {
                int newRowLength = 0;
                int[] colArr = new int[rowLength];
                for (int j=0; j<colLength; j++) {
                    for(int i=0; i<rowLength; i++) {
                        colArr[i] = arr[i][j];
                    }
                    Arrays.sort(colArr);
                    
                    List<int[]> countList = new ArrayList<>();
                    int cnt=1;
                    for(int i=0; i<rowLength; i++) {
                        if(colArr[i] == 0) continue;
                        if (i != rowLength-1 && colArr[i] == colArr[i+1]) {
                            cnt++;
                        } else {
                            countList.add(new int[]{colArr[i], cnt});
                            cnt = 1;
                        }
                    }
                    countList.sort((a, b) -> {
                        if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                        return Integer.compare(a[0], b[0]);
                    });
                    int i=0;
                    int localRowLength = 0;
                    for (int[] pair : countList) {
                        if (i>=100) break;
                        arr[i++][j] = pair[0];
                        if (i>=100) break;
                        arr[i++][j] = pair[1];
                        localRowLength+=2;
                    }
                    if (newRowLength < localRowLength)
                        newRowLength = localRowLength;
                    for(; i<100; i++) {
                        arr[i][j] = 0;
                    }
                }
                rowLength = newRowLength;
            }
            count++;
        }
        System.out.println(-1);
    }
}