import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String word;
		word = scan.nextLine();
		String[] strArr = word.split("");
		for(int i=0; i<word.length(); i++) {
			System.out.print(strArr[i]);
			if(i%10==9) System.out.println();
		}

	}

}
