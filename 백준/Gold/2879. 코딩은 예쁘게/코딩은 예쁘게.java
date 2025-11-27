import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int cur, target;

        Node(int cur, int target) {
            this.cur = cur;
            this.target = target;
        }

        @Override
        public String toString() {
            return "{" + cur + ", " + target + "}";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st2.nextToken());

            s1.add(new Node(cur, target));
        }

        int answer = 0;
        while(!s1.isEmpty()) {

            Node start = s1.pop();
            
            //줄여야할때가 false, 더해야할때가 true
            boolean check = true;
            if(start.cur == start.target) continue;
            else if(start.cur > start.target) check = false;
            s2.add(start);
            while(!s1.isEmpty()) {
                Node n = s1.peek();

                //줄여야 하는데 이전에 나온게 늘려야 하는거라면 멈춰
                if(n.cur > n.target && check) break;

                //줄여야 하는데 이전에 나온게 늘려야 하는거라면 멈춰
                if(n.cur < n.target && !check) break;

                //또는 cur, target 같은 애면 멈춰
                if(n.cur == n.target) break;

                //지금 뽑은 애 이전 것과 같은 작업을 해야 하는 경우 s2에 넣어준다.
                s1.pop();
                s2.add(n);
            }

            //s2에 있는 아이들 작업해서 넣어주기
            while(!s2.isEmpty()) {
                Node n = s2.pop();
                if(check) n.cur++;
                else n.cur--;
                s1.add(n);
            }

            //작업횟수 ++
            answer++;
        }

        System.out.println(answer);
    }
}