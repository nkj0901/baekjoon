import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> fivo = new ArrayList<>();
        long N = Long.parseLong(br.readLine());
        int maxCnt = -1;

        //피보나치 수열 만들기
        fivo = new ArrayList<>();
        fivo.add(1L);
        fivo.add(2L);

        while(true) {
            long a = fivo.get(fivo.size()-1);
            long b = fivo.get(fivo.size()-2);
            long next = a + b;
            if(next > N) break;
            fivo.add(next);
        }

        //젝켄도르프 정리 사용
        //F(1) + F(2) + ... + F(k) = F(k+2) - 2
        //ex) f(7) = 21 = f(5) + 2
        //따라서 f(7-1)을 무조건 사용해야 함
        List<Long> answer = new ArrayList<>();
        for(int i = fivo.size()-1; i >= 0; i--) {
            long curNum = fivo.get(i);
            if(curNum <= N) {
                N-=curNum;
                answer.add(curNum);
                //연속되면 안됨
                i--;
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size() > 0 ? answer.size() : -1);
        for(long l : answer) System.out.print(l + " ");
    }
}