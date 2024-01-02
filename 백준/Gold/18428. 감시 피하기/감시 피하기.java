import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static String answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        char cur;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                cur = str.charAt(j*2);
                if(cur == 'T') arr[i][j] = 1;
                else if(cur == 'S') arr[i][j] = 2;
            }
        }

        //조합
        answer = "NO";
        combi(0, 0);
        System.out.println(answer);
    }

    private static void combi(int num, int idx){
        if(answer.equals("YES")) return;
        if(num == N*N) return;
        if(idx == 3) {
            //다 숨었는지 보기
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] == 1) {
                        for(int d = 0; d < 4; d++) {
                            if(!look(i, j, d)) return;
                        }
                    }
                }
            }
            answer = "YES";
            return;
        }

        int x = num/N;
        int y = num%N;
        if(arr[x][y] != 0) combi(num+1, idx);
        else {
            arr[x][y] = 3;
            combi(num+1, idx+1);
            arr[x][y] = 0;
            combi(num+1, idx);
        }
    }

    private static boolean look(int r, int c, int d) {
        int next = 1;
        while(true) {
            int nr = r+(dr[d]*next);
            int nc = c+(dc[d]*next);

            if(nr >= N || nc >= N || nr < 0 || nc < 0) return true;
            if(arr[nr][nc] == 3) return true;
            if(arr[nr][nc] == 2) return false;

            next++;
        }
    }
}