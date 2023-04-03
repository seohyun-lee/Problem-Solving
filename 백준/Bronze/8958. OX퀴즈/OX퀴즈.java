import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine(); //남아있는 엔터 없애기
		for(int i=0; i<n; i++) {
			String s = sc.nextLine();
			int sum=0;
			int cnt=0;
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j)=='O') {
					cnt++;
					sum+=cnt;
				}
				else cnt=0;
			}
			System.out.println(sum);
		}
		sc.close();
	}

}
