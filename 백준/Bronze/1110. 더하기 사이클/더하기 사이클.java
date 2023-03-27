import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int num1=n;
		int num2=0;
		for(int i=1;;i++) {
			num2 = (num1%10)*10 + (num1/10+num1%10)%10;
			if(n==num2) {
				System.out.println(i);
				break;
			}
			else {
				num1 = num2;
			}
		}
	}

}