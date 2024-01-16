import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int h = 1;
        int startIdx = 0;
        int s = arr[0][0];
        int e = arr[0][1];
        int answer = 0;

        for(int i= 1; i < N; i++) {
            //다음 일정의 시작일이 마지막 일정의 종료일+1보다 크면 닿아있지 않다는 것(다른 사각형)
            if(arr[i][0] > e+1) {
                answer += (e - (s-1))*h;
                h = 1;
                startIdx = i;
                s = arr[i][0];
                e = arr[i][1];
                continue;
            }
            //일정이 겹친다면(갑은 사각형)
            e = Math.max(e, arr[i][1]);
            //뒤에 이어서 붙일 수 있는지 확인
            boolean check = false;
            for(int j = startIdx; j < i; j++) {
                if(arr[i][0] > arr[j][1]) {
                    check = true;
                    arr[j][1] = arr[i][1];
                    arr[i][1] = 365;
                    break;
                }
            }
            if(!check) h++;
        }
        answer+=(e - (s-1))*h;
        System.out.println(answer);
    }
}