import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine())-1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int start = i;
            int end = arr[start];
            List<Integer> candList = new ArrayList<>();
            for(int j=0; j<n; j++) {
                if (start == end) {
                    candList.add(end);
                    for(Integer in : candList) {
                        if (!list.contains(in+1))
                            list.add(in+1);
                    }
                    break;
                } else {
                    candList.add(start);
                    end = arr[end];
                }
            }
        }
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}