import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int N1 = N;// N에 변동이 일어나면 안되니까 N의 값을 N1에 저장
		int sum = 0;
		int n10 = 0; // 십의 자리
		int n1 = 0; // 일의 자리
		int cnt = 0;
		//
		while (true) {
			cnt++;
			if (N1 < 10) {
				n10 = 0;
				n1 = N1;
			} else {
				n10 = N1 / 10;
				n1 = N1 % 10;
			}
			// 십의 자리와 일의자리를 더하여 합을 만들기
			sum = n10 + n1;
			// 합의 일의 자리와 기존 일의 자리를 이용해 새로운 숫자 만들기
			N1 = (n1 * 10) + (sum % 10);

			if (N1 == N) {
				bw.write(cnt + "");
				bw.newLine();
				break;
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}