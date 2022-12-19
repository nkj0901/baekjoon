import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int time = sc.nextInt();
		
		int a = time/60;
		int b = time%60;
		
		
		int c = (A+a+((B+b)/60));
		int d = ((B+b)%60);
		
		if(c>=24){
			A = c - 24;
			System.out.println(A + " " + d);
		} else {
			System.out.println(c +" "+ d);
		}
	}
}