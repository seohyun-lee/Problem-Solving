import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int c = input.nextInt();
		for(int i=0;i<c;i++) {
			int n = input.nextInt();
			int[] score = new int[n];
			double average = 0;
			double ratio = 0;
			
			for(int j=0;j<n;j++) {
				score[j] = input.nextInt();
				average+=score[j];
			}
			average/=n;
			
			for(int j=0;j<n;j++) {
				if(score[j]>average) ratio++;
			}
			System.out.printf("%.3f%%\n", ratio/n*100);
		}
		input.close();
	}

}
