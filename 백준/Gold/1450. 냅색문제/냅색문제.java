import java.io.*;
import java.util.*;

public class Main
{
    private static List<Long> subsetSum(int[] arr, int left, int len) {
        List<Long> result = new ArrayList<>();
        int limit = 1 << len; // 비트마스킹으로 여부를 확인
        for (int i = 0; i < limit; i++) {
            long sum = 0;
            for (int j = 0; j < len; j++) { // len자리의 이진법 수에서
                if (((i >> j) & 1) == 1) { // 값이 1인 자리를 체크해 저장
                    sum += arr[left+j];
                }
            }
            result.add(sum);
        }
        return result;
    }

    static long binarySearch(List<Long> list, long key) {
        if (key < 0)
            return 0;
        long left = 0;
        long right = list.size();
        while (left < right) {
            long mid = (left + right) / 2;
            if (list.get((int)mid) <= key)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long cnt = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        List<Long> list1 = subsetSum(arr, 0, n/2);
        List<Long> list2;
        if (n%2==0) list2 = subsetSum(arr, n/2, n/2);
        else list2 = subsetSum(arr, n/2, n/2+1);
        Collections.sort(list2); // 정렬
        // 중간에서 만나기
        for (int i = 0; i < list1.size(); i++)
            cnt += binarySearch(list2, c-list1.get(i));
        System.out.println(cnt);
    }
}