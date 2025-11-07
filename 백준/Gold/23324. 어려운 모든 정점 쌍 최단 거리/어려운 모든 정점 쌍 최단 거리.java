import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long answer = 0;

        List<Integer>[] list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        //노드 저장
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if(K == i+1) continue;
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int count = 0;
        while(!q.isEmpty()) {
            int n = q.poll();
            if(visited[n]) continue;
            visited[n] = true;
            count++;
            q.addAll(list[n]);
        }

        int a = count;
        int b = N - a;

        answer = (long) a * b;

        System.out.println(answer);
    }
}