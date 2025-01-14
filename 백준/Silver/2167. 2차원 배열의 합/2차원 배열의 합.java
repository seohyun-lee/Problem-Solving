import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[][] arr = new int[n][m];
		for(int a=0; a<n; a++) {
			for(int b=0; b<m; b++) {
				arr[a][b] = sc.nextInt();
			}
		}
		
		int k=sc.nextInt();
		for(int l=0; l<k; l++) {
			int i=sc.nextInt();
			int j=sc.nextInt();
			int x=sc.nextInt();
			int y=sc.nextInt();
			int sum=0;
			
			for(int a=i-1; a<=x-1; a++) {
				for(int b=j-1; b<=y-1; b++) {
					sum+=arr[a][b];
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}
}