import java.io.*;
import java.util.*;

public class Main {
    static int N, P, K;
    static List<Edge>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int maxCost = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c));
            adj[b].add(new Edge(a, c));
            maxCost = Math.max(maxCost, c);
        }

        int left = 0, right = maxCost, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canReach(mid)) { // mid 이하의 비용으로 연결 가능?
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    // BFS or Dijkstra-like 탐색
    static boolean canReach(int limit) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.used > dist[cur.idx]) continue;
            if (cur.idx == N) return true; // 도착 성공

            for (Edge next : adj[cur.idx]) {
                int nextUsed = cur.used + (next.weight > limit ? 1 : 0);
                if (nextUsed <= K && nextUsed < dist[next.to]) {
                    dist[next.to] = nextUsed;
                    pq.add(new State(next.to, nextUsed));
                }
            }
        }
        return false;
    }

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State implements Comparable<State> {
        int idx, used; // used = 무료설치 사용횟수
        State(int idx, int used) {
            this.idx = idx;
            this.used = used;
        }
        @Override
        public int compareTo(State o) {
            return this.used - o.used;
        }
    }
}