import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {

			// 배열만들기
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> arr = new ArrayList<>();

			while (st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				arr.add(tmp);
			}
			// 첫번째꺼 제외하고 다 더하기
			int sum = 0;
			for (int j = 1; j < arr.size(); j++) {
				sum += arr.get(j);
			}
			// 첫번째 배열 숫자로 나누기
			double ave = (double) sum / arr.get(0);
			//평균을 넘는 학생들 수
			int cnt =0;
			for (int j = 1; j < arr.size(); j++) {
				if (arr.get(j) > ave) {
					cnt++;
				}
			}
			double ratio = (double) cnt/arr.get(0)*100;
			double ans = Math.round(ratio*1000)/1000.0;
			System.out.printf("%.3f", ans);
			System.out.println("%");
		}

	}
}
