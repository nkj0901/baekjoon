import java.io.*;
import java.util.*;

public class Main {

    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        p = new int[N+1];

        //진실을 아는 사람 array
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int[] know = new int[num];
        for(int i = 0; i < num; i++) {
            know[i] = Integer.parseInt(st.nextToken());
        }

        //파티 참여 list 만들기
        List<Integer>[] list = new ArrayList[M];
        for(int i = 0; i < M; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            make_set(i);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int part = Integer.parseInt(st.nextToken());
            int first = 0;
            for(int j = 0; j < part; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));

                if(j == 0) first = list[i].get(j);
                else union(first, list[i].get(j));

            }
        }

        boolean[] isKnow = new boolean[N+1];
        for(int i = 0; i < know.length; i++) {
            int root = find_set(p[know[i]]);

            for(int j = 1; j < N+1; j++) {
                if(find_set(p[j]) == root) isKnow[j] = true;
            }
        }

        //몇번 과장할 수 있는지 찾아보기
        for(int i = 0; i < M; i++) {
            if(!isKnow[list[i].get(0)]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void make_set(int x) {
        p[x] = x;
    }

    private static int find_set(int x) {
        if(p[x] == x) return p[x];
        return find_set(p[x]);
    }

    private static void union(int a, int b) {
        p[find_set(b)] = find_set(a);
    }
}