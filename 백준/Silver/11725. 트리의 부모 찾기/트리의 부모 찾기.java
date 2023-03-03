import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] list = new ArrayList[N+1];

        for(int i = 1; i < N+1; i++){
            list[i] = new ArrayList<>();
        }

        //그래프 만들기
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        //조회
        int[] ans = new int[N+1];
        boolean[] check = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = true;

        while(!queue.isEmpty()){
            int n = queue.poll();

            for(int num : list[n]){
                if(check[num]) continue;
                check[num] = true;
                ans[num] = n;
                queue.add(num);
            }
        }

        //출력
        for(int i = 2; i < N+1; i++){
            System.out.println(ans[i]);
        }
    }
}