import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			String s = sc.next();
			System.out.println(s.charAt(0)+""+s.charAt(s.length()-1));
		}
	}

}