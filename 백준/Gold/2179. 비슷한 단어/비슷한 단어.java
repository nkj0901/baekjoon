import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            map.put(arr[i], i);
        }

        Arrays.sort(arr);
        map.put("", N);
        String answer1 = "";
        String answer2 = "";

        int same = 0;
        for(int i = 0; i < N-1; i++) {
            String cur = arr[i];
            for(int j = i+1; j < N; j++){
                String next = arr[j];

                int cnt = 0;
                for(int z = 0; z < cur.length(); z++) {
                    if(cur.charAt(z) == next.charAt(z)) cnt++;
                    else break;
                }

                if(cnt > same){
                    if(map.get(cur) > map.get(next)) {
                        answer1 = next;
                        answer2 = cur;
                    } else {
                        answer1 = cur;
                        answer2 = next;
                    }
                    same = cnt;
                } else if (cnt == same) {
                    //cur이 더 먼저 나온 애이면,
                    if(map.get(cur) < map.get(next)) {
                        if(map.get(answer1) > map.get(cur)) {
                            answer1 = cur;
                            answer2 = next;
                        } else if(answer1.equals(cur)){
                            if(map.get(answer2) > map.get(next)) answer2 = next;
                        }
                        //next가 더 먼저 나온 애이면,
                    } else {
                        if(map.get(answer1) > map.get(next)){
                            answer1 = next;
                            answer2 = cur;
                        } else if(answer1.equals(next)){
                            if(map.get(answer2) > map.get(cur)) answer2 = cur;
                        }
                    }
                }
            }

        }
        System.out.println(answer1);
        System.out.println(answer2);
    }
}