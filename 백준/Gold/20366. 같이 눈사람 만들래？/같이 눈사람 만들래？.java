import java.io.*;
import java.util.*;

public class Main
{
    static class Snowman {
        int sum, i, j;
        Snowman(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        
        // 모든 만들어질 수 있는 스노우맨을 저장
        List<Snowman> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                list.add(new Snowman(arr[i]+arr[j], i, j));
            }
        }
        Collections.sort(list, Comparator.comparingInt(snowman->snowman.sum));
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<list.size()-1; i++) {
            Snowman a = list.get(i);
            Snowman b = list.get(i+1);
            if (a.i != b.i && a.i != b.j && a.j != b.i && a.j != b.j)
                min = Math.min(min, Math.abs(list.get(i).sum - list.get(i+1).sum));
        }
        System.out.println(min);
    }
}