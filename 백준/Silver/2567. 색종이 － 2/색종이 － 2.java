import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 도화지 만들기
		int[][] arr = new int[102][102];

		// 종이의 개수
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		// 종이 붙이는 개수만큼 반복문 돌리기
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if (arr[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int dx = i + dr[k];
						int dy = j + dc[k];
						
						if (arr[dx][dy] == 0) {
							cnt++;
						}
						if (dx > 101 || dx < 0 ||  dy > 101 && dy < 0) {
							cnt++;
						}
					}
				}
			}
		}

		bw.write(cnt + "");
		bw.flush();
		br.close();
		bw.close();
	}
}