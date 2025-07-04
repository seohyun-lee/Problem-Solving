import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        int simCount = 1;

        while(!(line = br.readLine()).equals("0")) {
            String[] parts = line.split(" ");
            int cacheSize = Integer.parseInt(parts[0]);
            String ops = parts[1];

            sb.append("Simulation ").append(simCount++).append('\n');
            Deque<Character> dq = new ArrayDeque<>();

            for(char c : ops.toCharArray()) {
                if(c == '!') {
                    for(char x : dq)
	                      sb.append(x);
                    sb.append('\n');
                    continue;
                }
                if(cacheSize == 0)
                    continue;
                if(dq.contains(c)) {
                    dq.remove(c);
                    dq.addLast(c);
                } else {
                    dq.addLast(c);
                    if (dq.size() > cacheSize) {
                        dq.pollFirst();
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
