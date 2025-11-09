import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        String[] minusSplit = expr.split("-");
        int result = 0;
        for (int i = 0; i < minusSplit.length; i++) {
            int groupSum = 0;
            String[] plusSplit = minusSplit[i].split("\\+");
            for (String num : plusSplit) {
                groupSum += Integer.parseInt(num);
            }
            if (i == 0) result = groupSum;
            else result -= groupSum;
        }
        System.out.println(result);
    }
}
