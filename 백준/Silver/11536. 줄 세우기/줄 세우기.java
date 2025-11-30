import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n], inc, dec;
        for (int i = 0; i < n; i++) arr[i] = br.readLine();
        inc = arr.clone();
        dec = arr.clone();
        Arrays.sort(inc);
        Arrays.sort(dec, Collections.reverseOrder());
        if (Arrays.equals(arr, inc)) System.out.println("INCREASING");
        else if (Arrays.equals(arr, dec)) System.out.println("DECREASING");
        else System.out.println("NEITHER");
    }
}
