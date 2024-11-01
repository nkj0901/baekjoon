import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long fac = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
            fac*=i;
        }

        //지금 봐야할 idx
        int idx = 0;
        k--; //idx가 0부터 시작하니까 --
        while(idx < n) {
            fac/=(n-idx);
            long value = k/fac;
            answer[idx] = list.get((int)value);
            list.remove((int) value);
            idx++;
            k%=fac;
        }    
        return answer;
    }
}
