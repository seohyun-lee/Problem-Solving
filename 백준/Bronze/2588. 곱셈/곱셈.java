import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b;
		a=input.nextInt();
		b=input.nextInt();
		System.out.println(a*(b%10));
		System.out.println(a*(b/10%10));
		System.out.println(a*(b/100));
		System.out.println(a*b);
		input.close();
	}
}
