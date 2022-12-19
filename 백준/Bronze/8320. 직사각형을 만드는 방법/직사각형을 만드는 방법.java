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

		// 1줄부터 n줄로 나열할 경우
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i; i*j <= N; j++) {
					cnt++;
			}
		}

		bw.write(cnt + "");
		bw.flush();
		br.close();
		bw.close();
	}
}