import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int H, M;
		H = input.nextInt();
		M = input.nextInt();
		if(M>=45) {
			M-=45;
		}
		else {
			M+=15;
			if(H==0) {
				H=23;
			}
			else {
				H--;
			}
		}
		System.out.println(H + " " + M);
	}

}
