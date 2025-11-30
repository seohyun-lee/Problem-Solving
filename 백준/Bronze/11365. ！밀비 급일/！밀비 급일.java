import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    while(true){
	        StringBuffer sb = new StringBuffer(br.readLine());
    	    if(sb.toString().equals("END"))
    	        break;
    	    else {
    	        System.out.println(sb.reverse().toString());
    	    }
	    }
	}
}