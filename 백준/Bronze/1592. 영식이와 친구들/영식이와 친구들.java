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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		// N만큼의 배열을 만든다.
		int[] arr = new int[N];

		// 처음으로는 N이 공을 받는다. 홀수이므로 오른쪽으로 L번만큼 던진다.
		int start = 0;
		arr[0]++;
		int count = 0;
		
		while(true) {
			// 배열 중 어느 곳 하나라도 3이되면 게임이 끝난다.
			if (arr[start]==M) {
				break;
			}
			// 짝수이면 시계반대방향에 있는 M번째 있는 인덱스에 ++
			// 만약 받은 사람이 수가 L보다 작을 때.(시계반대방향의 경우) N-해당수-L
			if (arr[start]%2==0) {
				if (start < L) {
					 arr[N+start-L]++;
					 start = N+start-L;
				} else {
					arr[start - L]++;
					start = start - L;
				}
			// 해당 배열에 있는 숫자에 ++해서 홀수 이면 시계방향으로 M번째 있는 인덱스에 ++
			// 받은 사람의 수 + L이 N보다 클 때. 해당수 + L - N
			} else {
				if (start+L >= N) {
					arr[start+L-N]++;
					start = start+L-N;
				} else {
					arr[start+L]++;
					start = start+L;
				}
			}
			// 어느 곳이든 3이 되는 경우 공이 옮겨다닌 횟수는?
			count++;
		}
		bw.write(count+"");
		bw.flush();
		br.close();
		bw.close();
	}
}