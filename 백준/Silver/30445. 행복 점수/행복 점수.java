import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine().trim();
        String happy = "HAPY";
        String sad = "SAD";
        int h=0;
        int s=0;
        for (char c : msg.toCharArray()) {
            if (happy.indexOf(c) >= 0) h++;
            if (sad.indexOf(c) >= 0) s++;
        }
        double ratio;
        if (h == 0 && s == 0)
            ratio = 0.5;
        else
            ratio = (double) h / (h+s);
        System.out.printf("%.2f%n", ratio*100);
    }
}