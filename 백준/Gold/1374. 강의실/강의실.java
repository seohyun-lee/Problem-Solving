import java.io.*;
import java.util.*;

public class Main {
    static TreeMap<Integer, Integer> multiset = new TreeMap<>();
    static int size=0;
    static void addNewClassRoom(int x){
        multiset.put(x, multiset.getOrDefault(x, 0)+1);
        size++;
    }
    static void updateEndTime(int x, int y){
        if(!multiset.containsKey(x)) return;
        if(multiset.get(x)==1) multiset.remove(x);
        else multiset.put(x, multiset.get(x)-1);
        multiset.put(y, multiset.getOrDefault(y, 0)+1);
    }
    static int getMin(){ return multiset.firstKey(); }
    static int getMax(){ return multiset.lastKey(); }
    
    static int solution(int N, int[][] lectures) {
        Arrays.sort(lectures, (a, b)->{
            if(a[1]==b[1]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[1], b[1]);
        });
        addNewClassRoom(lectures[0][2]);
        for(int i=1; i<N; i++){
            if(getMin()<=lectures[i][1]){
                updateEndTime(getMin(), lectures[i][2]);
            } else {
                addNewClassRoom(lectures[i][2]);
            }
        }
        
        return size;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
            lectures[i][2] = Integer.parseInt(st.nextToken());
        }
        int result = solution(N, lectures);
        System.out.println(result);
    }
}