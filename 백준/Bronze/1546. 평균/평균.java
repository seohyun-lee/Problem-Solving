import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m=0;
		n=sc.nextInt();
		int[] score = new int[1000];
		double average=0;
		for(int i=0;i<n;i++) {
			score[i]=sc.nextInt();
			if(score[i]>m)
				m=score[i];
			average+=score[i];
		}
		average=average/m*100/n;
		System.out.println(average);
	}

}
