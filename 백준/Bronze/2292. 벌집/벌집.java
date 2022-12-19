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
		int i = 1; // 1로부터 몇번째 줄에 있에 있는지 알려줌
		int sum = 1;
		
		while(true) {
			if (sum >= N) {
				break;
			} else {
				sum += 6*i;
				i++;
			}
		}
		bw.write(i+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
