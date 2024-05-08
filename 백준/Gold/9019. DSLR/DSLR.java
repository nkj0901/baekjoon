import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        String str;
        int num;

        Node(String str, int num) {
            this.str = str;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String answer = "";

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node("", a));
            boolean[] visited = new boolean[10000];
            visited[a] = true;

            while(!queue.isEmpty()) {
                Node node = queue.poll();

                if(node.num == b) {
                    answer = node.str;
                    break;
                }

                int num = node.num;
                String str = node.str;
                int next = 0;

                //1. D
                next = (num*2)%10000;
                if(!visited[next]) {
                    queue.add(new Node(str+"D", next));
                    visited[next] = true;
                }

                //2. S
                next = num == 0 ? 9999 : num-1;
                if(!visited[next]) {
                    queue.add(new Node(str+"S", next));
                    visited[next] = true;
                }

                //'L'
                next = num%1000*10 + num/1000;
                if(!visited[next]) {
                    queue.add(new Node(str+"L", next));
                    visited[next] = true;
                }

                //'R'
                next = num%10*1000 + num/10;
                if(!visited[next]) {
                    queue.add(new Node(str+"R", next));
                    visited[next] = true;
                }
            }

            System.out.println(answer);
        }
    }
}