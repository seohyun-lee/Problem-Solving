import java.io.*;
import java.util.*;

public class Main {
    static int[] A, tmp;
    static long result;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A = new int[n+1];
        tmp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        mergeSort(1, n);
        System.out.println(result);
    }
    
    private static void mergeSort(int s, int e) { 
        if (e-s < 1)
            return;
        int m = s + (e-s)/2;
        //재귀함수 (왼쪽, 오른쪽)
        mergeSort(s, m); 
        mergeSort(m+1, e);
        
        for (int i=s; i<=e; i++) {
            tmp[i] = A[i];
        }
        int k = s; // 병합 결과를 A에 저장하기위한 위치 인덱스
        int index1 = s; // 왼쪽 그룹의 현재 원소 위치
        int index2 = m + 1; // 오른쪽 그룹의 현재 원소 위치
        // 병합 로직 (작은 값을 A[k]에 넣으며 병합)
        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) { // 뒤쪽 데이터 값이 작다면 역전 발생
                A[k] = tmp[index2];
                result += (index2 - k); // 오른쪽 원소가 왼쪽 원소 몇 개를 앞질렀는지
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        // 두 부분 중 한 쪽이 먼저 소진되었을 때, 남은 원소 병합
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}