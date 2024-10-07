import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int F, G, U, D;

    static class Node{
        int curStair;
        int cnt;

        Node (int curStair, int cnt) {
            this.curStair = curStair;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int answer = -1;
        boolean[] visited = new boolean[F+1];

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cnt - o2.cnt;
            }
        });

        pq.add(new Node(S, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();

            if(n.curStair == G ) {
                answer = n.cnt;
                break;
            }
            if(n.curStair < 1 || n.curStair > F) continue;
            if(visited[n.curStair]) continue;
            visited[n.curStair] = true;

            pq.add(new Node(n.curStair + U, n.cnt+1));
            pq.add(new Node(n.curStair - D, n.cnt+1));
        }

        System.out.println(answer == -1 ? "use the stairs" : answer);
    }
}