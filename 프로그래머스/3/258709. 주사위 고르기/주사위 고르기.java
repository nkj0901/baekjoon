import java.util.*;
import java.io.*;

class Solution {
    
    int[][] sdice;
    boolean[] visited;
    int[] sel;
    int[] nonSel;
    int l, maxCnt, winCnt, cnt;
    int[] answer;
    
    public int[] solution(int[][] dice) {
        l = dice.length;
        answer = new int[l/2];
        sdice = dice;
        visited = new boolean[l];
        sel = new int[l/2];
        maxCnt = 0;
        cnt = 0;
        combination(0, 0);
        return answer;
    }
    
    public void combination(int idx, int sidx) {
        if(l/2 == sidx) {
            calc();
            return;
        }
        
        for(int i = idx; i < l; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            sel[sidx] = i;
            combination(i, sidx+1);
            visited[i] = false;
        }
    }
    
    public void calc(){
        winCnt = 0;
        nonSel = new int[l/2];
        
        int idx = 0;
        for(int i = 0; i < l; i++) {
            if(contains(sel, i)) continue;
            nonSel[idx++] = i;          
        }    
        
        int[] sel2 = new int[l/2];   

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        comb(0, sel2, list1); 
        comb2(0, sel2, list2);
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        int sum = 0;
        for(int i = 0; i < list1.size(); i++) {
            int num = list1.get(i);
            sum+=getIndex(0, list2.size()-1, num, list2);
        }
        // System.out.println(list1);
        // System.out.println(list2);
        // System.out.println(sum);
        
        
        if(maxCnt < sum) {
            maxCnt = sum;
            for(int i = 0; i < l/2; i++) {
                answer[i] = sel[i]+1;
            }
        }
    }
    
    public boolean contains(int[] sel, int num) {
        for(int i = 0; i < sel.length; i++) {
            if(sel[i] == num) return true;
        }
        return false;
    }
    
    void comb(int sidx, int[] sel2, List list) {
        if(sidx == l/2) {
            int sum = 0;
            for(int i = 0; i < sel2.length; i++) {
                sum+= sdice[sel[i]][sel2[i]];
            }
            list.add(sum);
            return;
        }
        
        for(int i = 0; i < 6; i++) {            
            sel2[sidx] = i;
            comb(sidx+1, sel2, list);
        }
    }
              
    void comb2(int sidx, int[] sel2, List list) {
        if(sidx == l/2) {
            int sum = 0;
            for(int i = 0; i < sel2.length; i++) {
                sum+= sdice[nonSel[i]][sel2[i]];
            }
            list.add(sum);
            return;
        }
        
        for(int i = 0; i < 6; i++) {            
            sel2[sidx] = i;
            comb2(sidx+1, sel2, list);
        }
    }
    
    
     int getIndex(int s, int e, int target, List<Integer> list) {
        
        while(s <= e){
            int m = (s + e) / 2;
            //만약 목표 num이 더 작은 경우에도 right = middle - 1 로 처리하여 해당 숫자가 질 수 있는 경우의 수를 구한다.
            if(target <= list.get(m)){
                e = m - 1;          
            } else if(target > list.get(m)){
                s = m + 1;
            }
        }
        return e;         
     }        
}