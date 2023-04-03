import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		int cnt=0;
		for(int i=0; i<s.length(); i++) {
			cnt++;
			if(i==s.length()-1)
				break;
			if (s.charAt(i)=='c') {
				if(s.charAt(i+1)=='='||s.charAt(i+1)=='-') {
					i++;
				}
			}
			
			else if (s.charAt(i)=='d') {
				if (s.charAt(i+1)=='z') {
					if (i<s.length()-2&&s.charAt(i+2)=='=') {
						i+=2;
					}
				}
				else if (s.charAt(i+1)=='-') {
					i++;
				}
			}
			
			else if (s.charAt(i)=='l') {
				if (s.charAt(i+1)=='j') {
					i++;
				}
			}
			
			else if (s.charAt(i)=='n') {
				if (s.charAt(i+1)=='j') {
					i++;
				}
			}
			
			else if (s.charAt(i)=='s') {
				if (s.charAt(i+1)=='=') {
					i++;
				}
			}
			
			else if (s.charAt(i)=='z') {
				if (s.charAt(i+1)=='=') {
					i++;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
