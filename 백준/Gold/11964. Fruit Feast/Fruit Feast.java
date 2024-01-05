import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, A, B, answer;

    static class Node{
        int f;
        boolean check;
        Node(int f, boolean check) {
            this.f = f;
            this.check = check;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        answer = 0;
        if(T%A==0) answer = T;
        if(T%B==0) answer = T;
        bfs();

        System.out.println(answer);
    }

    private static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(A, false));
        queue.add(new Node(B, false));

        while(!queue.isEmpty()){

            Node cur = queue.poll();
            if(T == answer) continue;

            if(cur.f > T) continue;
            answer = Math.max(answer, cur.f);

            if(!cur.check) {
                queue.add(new Node(cur.f/2, true));
            }
            queue.add(new Node(cur.f+A, cur.check));
            queue.add(new Node(cur.f+B, cur.check));
        }
    }
}