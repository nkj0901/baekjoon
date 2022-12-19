import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int ans = 0;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 금은동 배열만들기
		int[] gold = new int[N + 1];
		int[] silver = new int[N + 1];
		int[] bronze = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			gold[i] = Integer.parseInt(st.nextToken());
			silver[i] = Integer.parseInt(st.nextToken());
			bronze[i] = Integer.parseInt(st.nextToken());
		}

		// 금매달 배열 순회
		int gcnt = 0; // 나보다 메달 많은 국가 수
		int iIndex = 0; // 만약 같은 애가 있으면 인덱스 여기 저장
		boolean same = false;
		for (int i = 1; i <= N; i++) {
			if (i != K && gold[K] < gold[i]) {
				gcnt++;
			} else if (i != K && gold[K] == gold[i]) {
				// 같은 애가 있으면 true로 바꿔 줌
				same = true;
				iIndex = i;
			}
		}
		if (same = true) {
			if (silver[K] > silver[iIndex]) {
				ans = gcnt + 1;
			} else if (silver[K] < silver[iIndex]) {
				ans = gcnt + 2;
			} else if (silver[K] == silver[iIndex]) {
				if (bronze[K] < bronze[iIndex]) {
					ans = gcnt + 2;
				} else {
					ans = gcnt+1;
				}
			}
		} else {
			ans = gcnt + 1;
		}
		bw.write(ans+"");
		bw.flush();
		br.close();
		bw.close();
	}
}