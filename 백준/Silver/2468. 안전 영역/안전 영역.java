import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] visited;
	static int cnt;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		// 배열채우기
		int max = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		//최대 높이 -1한 값부터 돌려가면서 섬이 몇개씩 나오는지 확인해보기
		for (int d = max-1; d>=0; d--) {
			cnt = 0;
			
			visited = new int[N][N];
			
			//큰 높이부터 돌아가면서 안전지대 세보기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > d && visited[i][j] == 0) {
					cnt++;
//					System.out.println(d + " " + i + " " + j +" " + map[i][j]);
					dfs(i, j, d);
				}
			}
		}
		ans = Math.max(cnt, ans);
		}
		bw.write(ans+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
	static void dfs(int r, int c, int deep) {
		visited[r][c] = 1;
		
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if (nr>=0 && nr<N && nc>=0 && nc<N) {
				if(map[nr][nc] > deep && visited[nr][nc] == 0) {
					dfs(nr, nc, deep);
				}
			}
		}
	}
}