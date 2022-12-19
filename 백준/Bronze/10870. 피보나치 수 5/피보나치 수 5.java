import java.util.Scanner;

public class Main {
	static int ans;

	public static int fivo(int N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		return fivo(N-1) + fivo(N-2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		System.out.println(fivo(N));
	}
}