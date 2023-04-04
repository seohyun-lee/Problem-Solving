import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		int[] alphaArray = new int[26];
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if (c>='a'&&c<='z') {
				alphaArray[(int)(c-'a')]++;
			}
			else if (c>='A'&&c<='Z') {
				alphaArray[(int)(c-'A')]++;
			}
		}
		
		int cnt=-1;
		int mostAlphaIndex=0;
		for(int i=0;i<26;i++) {
			if(alphaArray[i]>cnt) {
				cnt=alphaArray[i];
				mostAlphaIndex=i;
			}
			else if (alphaArray[i]==cnt) {
				mostAlphaIndex=-2;
			}
		}
		System.out.println((char)(mostAlphaIndex+65));
	}

}
