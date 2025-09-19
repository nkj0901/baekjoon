import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        List<Integer> list = new ArrayList();
        
        for(int i = 0; i < 24; i++) {
            
            //list 돌면서 server 사용시간 줄이기
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) == 1) {
                    list.remove(j);
                  //삭제했으니까 j하나 줄여주기
                    j--;
                } else list.set(j, list.get(j) -1);
            }
            
            //players를 확인해서 몇대의 서버가 필요한지 보고 list의 길이보다 적으면 list에 새로운 서버 넣어주기
            if(players[i]/m > list.size()) {
                while(players[i]/m > list.size()){
                    list.add(k);
                    answer++;
                }
            }
        }
        return answer;
    }
}