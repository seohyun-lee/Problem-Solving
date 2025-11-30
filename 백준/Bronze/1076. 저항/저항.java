import java.io.*;

public class Main
{
    static long regCalc(String s, int op){
        if(s.equals("black"))  return (op < 2 ? 0 : 1);
        if(s.equals("brown"))  return (op < 2 ? 1 : 10);
        if(s.equals("red"))    return (op < 2 ? 2 : 100);
        if(s.equals("orange")) return (op < 2 ? 3 : 1000);
        if(s.equals("yellow")) return (op < 2 ? 4 : 10000);
        if(s.equals("green"))  return (op < 2 ? 5 : 100000);
        if(s.equals("blue"))   return (op < 2 ? 6 : 1000000);
        if(s.equals("violet")) return (op < 2 ? 7 : 10000000);
        if(s.equals("grey"))   return (op < 2 ? 8 : 100000000);
        if(s.equals("white"))  return (op < 2 ? 9 : 1000000000);
        return 0;
    }
    
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    long val = 0;
	    for(int i=0; i<2; i++)
    	    val = val*10+regCalc(br.readLine(), i);
	    val *= regCalc(br.readLine(), 2);
	    System.out.println(val);
	}
}