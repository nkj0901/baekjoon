import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());
        int[][] notebook = new int[N][M];
        int answer = 0;

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[R][C];

            for(int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < C; c++) {
                    sticker[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            //들어갈 수 있는지 확인
            boolean check = isOk(sticker, notebook, R, C);


            //만약 못 들어간다면 돌려봐
            if(!check) {
                for(int d = 0; d < 3; d++) {
                    sticker = rotation(sticker);
                    if(isOk(sticker, notebook, sticker.length, sticker[0].length
                    )) break;
                }
            }
        }

        for(int i = 0; i < N; i++) {
           for(int j = 0; j < M; j++){
                answer+=notebook[i][j];
            }
        }
        System.out.println(answer);
    }

    //들어가는지 확인
    private static boolean isOk(int[][] sticker, int[][] notebook, int R, int C) {

        boolean check = true;
        loop1 : for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                check = true;

                loop2: for(int a = 0; a < R; a++) {
                    for(int b = 0; b < C; b++) {
                        if(r+a>= N || c+b >=M || (notebook[r+a][c+b] == 1 && sticker[a][b] == 1)) {
                            check = false;
                            break loop2;
                        }
                    }
                }

                //스티커 붙이기
                if(check) {
                    for(int a = 0; a < R; a++) {
                        for(int b = 0; b < C; b++) {
                            if(sticker[a][b] == 1)
                            notebook[r+a][c+b] = 1;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static int[][] rotation(int[][] arr) {
        int[][] change = new int[arr[0].length][arr.length];

        for(int i = 0; i < arr[0].length; i++) {
            for(int j = 0; j < arr.length; j++) {
                change[i][change[0].length-1-j] = arr[j][i];
            }
        }
        return change;
    }
}