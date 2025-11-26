import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Shark {
        int idx, r, c, s, d, z;

        Shark (int idx, int r, int c, int s, int d, int z) {
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Shark[] sharks = new Shark[M];

        List<Shark>[][] arr = new ArrayList[R][C];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) -1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(i, r, c, s, d, z);
            sharks[i] = shark;

            arr[r][c].add(shark);
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,1,-1};
        int answer = 0;
        for(int i = 0; i < C; i++) {

            //가장가까운 상어 잡기
            for(int j = 0; j < R; j++) {
                if(arr[j][i].size() > 0) {
                    answer+= arr[j][i].get(0).z;
                    sharks[arr[j][i].get(0).idx] = null;
                    arr[j][i].clear();
                    break;
                }
            }

            //상어옮겨주기
            for(int j = 0; j < M; j++) {
                Shark cur = sharks[j];
                if(cur == null) continue;

                int nr = cur.r;
                int nc = cur.c;
                int d = cur.d;

                //기존 위치에서 삭제
                arr[nr][nc].clear();

                int s = cur.s;
                if (d == 0 || d == 1) s %= (R - 1) * 2;
                else s %= (C - 1) * 2;
                
                for(int z = 0; z < s; z++) {
                    nr = nr + dr[d];
                    nc = nc + dc[d];

                    if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
                        //다시 원복
                        nr = nr - dr[d];
                        nc = nc -dc[d];

                        //방향 바꿔주고 다시실행
                        if(d == 0 || d == 2) d+=1;
                        else d-=1;
                        z--;
                    }
                }

                //shark 정보 업데이트
                sharks[j].r = nr;
                sharks[j].c = nc;
                sharks[j].d = d;
            }

            //새로운 위치에 넣어주기
            for(int j = 0; j < M; j++) {
                Shark shark = sharks[j];
                if(shark != null) {
                    if(arr[shark.r][shark.c].size() > 0) {
                        Shark prev = arr[shark.r][shark.c].get(0);
                        if(prev.z < shark.z) {
                            sharks[prev.idx] = null;
                            arr[shark.r][shark.c].remove(0);
                            arr[shark.r][shark.c].add(shark);
                        } else sharks[j] = null;
                    }
                    else arr[shark.r][shark.c].add(shark);
                }
            }
        }
        System.out.println(answer);
    }
}