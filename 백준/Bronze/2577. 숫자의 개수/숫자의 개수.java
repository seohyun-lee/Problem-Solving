import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		String product = Integer.toString(a*b*c);

		int[] arr = new int[10];
		for(int i=0; i<product.length(); i++) {
			int temp = product.charAt(i)-48;
			arr[temp]++;
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(arr[i]);
		}
	}

}
