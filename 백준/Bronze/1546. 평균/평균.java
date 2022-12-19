import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		// 제일 큰 값 구하기, 배열에 값 저장하기
		int max = 0;
		int[] arr = new int[t];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (arr[i] > max)
				max = arr[i];
		}
		// /max*100해서 평균값을 구하자
		double sum = 0; //조작한 값을 합산한 수
		for ( int i = 0 ; i < t; i++) {
			double a = (double)arr[i]/max*100;
			sum+=a;
		}
		
		double ans = (double)sum/t;
		System.out.println(ans);
		br.close();
	}
}