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
        int answer = -1;

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        int maxCost = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            maxCost = Math.max(c, maxCost);
            adj[a].add(new Edge(b, c));
            adj[b].add(new Edge(a, c));
        }

        int left = 0;
        int right = maxCost;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(canReach(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canReach(int mid) {

        //mid 이하의 선만 사용했을 때 무료로 사용해야하는 선이 K개 이하인지 확인
        PriorityQueue<State> pq = new PriorityQueue<>();
        //최소 무료 횟수
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        //1부터 시작
        pq.add(new State(1, 0));

        while(!pq.isEmpty()) {
            State cur = pq.poll();

            if(cur.to == N) return true;

            //연결되어 있는 모든 것들 확인하기
            for(int i = 0; i < adj[cur.to].size(); i++) {
                Edge next = adj[cur.to].get(i);

                //만약 무료 횟수 초과하면 패쓰~
                if(cur.used + (next.weight > mid ? 1 : 0) > K) continue;

                //더 적게 써서 도달할 수 있으면 update하고 계속 탐색
                if(dist[next.to] > cur.used + (next.weight > mid ? 1 : 0)) {
                    dist[next.to] = cur.used + (next.weight > mid ? 1 : 0);
                    pq.add(new State(next.to, cur.used + (next.weight > mid ? 1 : 0)));
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
        int to, used;

        State(int to, int used) {
            this.to = to;
            this.used = used;
        }

        @Override
        public int compareTo(State e) {
            return this.used - e.used;
        }
    }

}