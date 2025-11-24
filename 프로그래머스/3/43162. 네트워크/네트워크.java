import java.util.*;
import java.io.*;

class Solution {
    
    int[] p;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        p = new int[n];
        
        for(int i = 0; i < n; i++) {
            make_set(i);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j= 0; j < n; j++) {
                if(computers[i][j] == 1 && i != j) union_set(i, j);
            }
        }
        
        // System.out.println(Arrays.toString(p));
        
        Set<Integer> set = new HashSet();
        for(int i = 0; i < n; i++) {
            set.add(find_set(i));
        }    

        return set.size();
    }
    
    public void make_set(int x) {
        p[x] = x;
    }
    
    public int find_set(int x) {
        if(p[x] != x) p[x] = find_set(p[x]);
        return p[x];
    }
    
    public void union_set(int x, int y) {
        p[find_set(y)] = find_set(x);
    }
}