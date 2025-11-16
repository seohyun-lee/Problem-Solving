import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String line;
        int total=0;
        while ((line = br.readLine()) != null && line.length() != 0) {
            map.put(line, map.getOrDefault(line, 0)+1);
            total++;
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys); // 종 이름 사전순 정렬
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            double percent = (map.get(key)*100.0)/total;
            sb.append(key).append(" ")
              .append(String.format("%.4f", percent))
              .append("\n");
        }
        System.out.print(sb);
    }
}
