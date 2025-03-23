import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        //일반인 눈으로 구역 보기
        int common = 0;
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j]) continue;
                common++;
                bfs(arr, visited, i, j);
            }
        }

        //적록색약 G을 R으로 바꾸기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 'G') arr[i][j] = 'R';
            }
        }

        //적록색약 눈으로 구역 보기
        int unCommon = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j]) continue;
                unCommon++;
                bfs(arr, visited, i, j);
            }
        }
        System.out.println(common + " " + unCommon);
    }

    private static void bfs(char[][] arr, boolean[][] visited, int r, int c) {
        if(visited[r][c]) return;
        visited[r][c] = true;

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c+ dc[d];

            if(nr >= arr.length || nr < 0 || nc >= arr.length || nc < 0) continue;
            if(arr[r][c] != arr[nr][nc]) continue;
            bfs(arr, visited, nr, nc);
        }
    }
}