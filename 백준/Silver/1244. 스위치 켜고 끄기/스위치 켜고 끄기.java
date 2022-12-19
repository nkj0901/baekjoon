import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 처음 스위치의 갯수
		int N = Integer.parseInt(br.readLine());

		// 스위치 갯수만큼 수를 받아서 배열을 만든다.
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 학생 수를 받는다.
		int student = Integer.parseInt(br.readLine());

		// 학생 수 만큼 성별과 수를 받는다.
		for (int i = 0; i < student; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(s.nextToken());
			int number = Integer.parseInt(s.nextToken());

			// 만약 남자이면 그 수의 배수를 바꾼다.
			if (sex == 1) {
				for (int j = 0; j < N; j++) {
					if ((j + 1) % number == 0) {
						if (arr[j] == 1) {
							arr[j] = 0;
						} else {
							arr[j] = 1;
						}
					}
				}
			}
			// 만약 여자이면 양쪽이 대칭이 만큼 상태를 바꾸고
			int r = 0; // 받은 숫자에 따른 for문 반복 범위
			if (sex == 2) {
				if (number > N/2) {
					r = N - number;
				} else {
					r = number-1;
				}

				for (int j = 0; j <= r; j++) {
					if (arr[number - 1 - j] == arr[number - 1 + j]) {
						if (arr[number - 1 - j] == 1) {
							arr[number - 1 - j] = 0;
							arr[number - 1 + j] = 0;
						} else {
							arr[number - 1 - j] = 1;
							arr[number - 1 + j] = 1;
						}
					} else {
						break;
					}
				}
			}
		}
		// 만약 스위치가 20 배수이면 아래줄에 출력한다.
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
			cnt++;

			if (cnt % 20 == 0) {
				System.out.println();
			}
		}
	}
}
