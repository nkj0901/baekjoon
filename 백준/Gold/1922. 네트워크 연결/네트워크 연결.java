import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 인접리스트 만들기
        List<Edge>[] list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Edge(e, w));
            list[e].add(new Edge(s, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        //정점 1에서부터 시작하자
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if(visited[e.to]) continue;
            visited[e.to] = true;
            answer+=e.weight;
            pq.addAll(list[e.to]);
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge>{
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}