import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int e, v;

        Node(int e, int v) {
            this.e = e;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] list = new List[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int[] time = new int[N+1];
        boolean[] visited = new boolean[N+1];
        int[] cnt = new int[N+1];
        int answer = 0;

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int prevCount = Integer.parseInt(st.nextToken());
            cnt[i] = prevCount;
            for(int j = 0; j < prevCount; j++) {
                list[Integer.parseInt(st.nextToken())].add(i);
            }
        }

        List<Node> go = new ArrayList<>();
        go.add(new Node(1, time[1]));
        visited[1] = true;
        while(true) {

            for(int i = 1; i <= N; i++) {
                if(cnt[i] == 0 && !visited[i]) {
                    go.add(new Node(i, time[i]));
                    visited[i] = true;
                }
            }

            if(go.isEmpty()) break;

            for(int i = 0; i < go.size(); i++) {
                Node cur = go.get(i);
                cur.v--;
                if(cur.v == 0) {
                    go.remove(cur);
                    i--;
                    for(int j = 0; j < list[cur.e].size(); j++) {
                        int deleteIdx = list[cur.e].get(j);
                        cnt[deleteIdx]--;
                    }
                }
            }

            answer++;
        }
        System.out.println(answer);
    }
}