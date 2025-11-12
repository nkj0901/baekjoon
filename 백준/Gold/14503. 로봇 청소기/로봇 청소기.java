import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        // 0: 북 / 1 : 동 / 2 : 남 / 3: 서쪽
        int d = Integer.parseInt(st.nextToken());
        if(d == 1) d = 3;
        else if(d == 3) d = 1;

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int curR = r;
        int curC = c;
        int curD = d;

        int answer = 1;
        arr[curR][curC] = 4;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        while(true) {
//            System.out.println("지금 curR = " + curR + " 지금 curC = " + curC + " 지금 curD = " + curD);
            boolean check = false; //치우지 않은 곳이 있는지 체크
            for(int i = curD + 1; i <= curD + 4; i++) {
                int idx = i%4;
                int nr = curR + dr[idx];
                int nc = curC + dc[idx];

                if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
                if(arr[nr][nc] != 0) continue;

                // 치우지 않은 곳이면 이동해서 치우기
                arr[nr][nc] = 4;
                curR = nr;
                curC = nc;
                curD = idx;
                check = true;
                answer++;
                break;
            }
            //청소할 수 있는 곳이 없을 경우
            //후진하는데 벽이면 멈춘다.
            if(!check) {
                int nr = curR + dr[(curD + 2)%4];
                int nc = curC + dc[(curD + 2)%4];
                if(nr >= N || nr < 0 || nc >= M || nc < 0) break;
                if(arr[nr][nc] == 1) break;
                if(arr[nr][nc] == 0) answer++;
                curR = nr;
                curC = nc;
            }
        }
        System.out.println(answer);
    }
}
