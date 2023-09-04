import java.util.*;

class Solution {
    
    static int[] p;
    public int solution(int n, int[][] costs) {

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        int V = 0;
        int answer = 0;
        p = new int[n];

        for(int i = 0; i < n; i++){
            p[i] = i;
        }

        for(int i = 0; i < costs.length; i++){
            if(find_set(costs[i][0]) == find_set(costs[i][1])) continue;
            union(costs[i][0], costs[i][1]);
            answer+=costs[i][2];
            V++;
            if(V == n-1) break;
        }
        return answer;
    }

    static int find_set(int idx){
        if(p[idx] != idx) p[idx] = find_set(p[idx]);
        return p[idx];
    }

    static void union(int s, int e){
        p[find_set(e)] = p[s];
    }
}