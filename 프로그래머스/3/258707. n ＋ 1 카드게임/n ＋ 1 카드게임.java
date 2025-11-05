import java.util.*;
import java.io.*;

//전략
//뽑은 카드를 list에 넣고 라운드 돌아가면서(2개씩 넣으면서) 다음 진행할 수 잇는지 보기

class Solution {
    List<Integer> list;
    boolean[] used;
    int n, cardIdx, coin;
    
    public int solution(int coin, int[] cards) {
        int answer = 1;
        n = cards.length;
        cardIdx = n/3;
        used = new boolean[n];
        this.coin = coin;
        
        //카드 n/3개 뽑기
        list = new ArrayList<>();
        for(int i = 0; i < cardIdx; i++) {
            list.add(cards[i]);
        } 
        
        for(int i = cardIdx; i < n-1; i+=2) {
            list.add(cards[i]);
            list.add(cards[i+1]);
            if(!summit()) break;
            answer++;
        }
        
        return answer;
    }
    
    public boolean summit() {
        // System.out.println(list);
        // System.out.println(Arrays.toString(used));
        // System.out.println(coin);
        
        boolean check = false;
        for(int i = 0; i < cardIdx; i++) {
            for(int j = i; j < cardIdx; j++) {
                if(list.get(i) + list.get(j) == n+1 && !used[i] && !used[j]) {
                    used[i] = true;
                    used[j] = true;
                    return true;
                }
            }
        }
        
        loop : for(int i = 0; i < list.size(); i++) {
            for(int j = i; j < list.size(); j++) {
                if(list.get(i) + list.get(j) == n+1 && !used[i] && !used[j]) {
                    used[i] = true;
                    used[j] = true;                
                
                    if(i >= cardIdx) coin--;
                    if(j >= cardIdx) coin--;
                    if(coin < 0) continue;
                    check = true;
                    break loop;
                }
            }
        }

        return check;
    }
}
