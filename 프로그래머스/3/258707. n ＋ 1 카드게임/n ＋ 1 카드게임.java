import java.util.*;
import java.io.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        int cardIdx = n/3;
        
        //짝의 idx가 어디인지 보기
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(cards[i] + cards[j] == n+1) {
                    arr[i] = j;
                }
            }
        }
        
        //짝지을 수 있는 것들이 나왔을 때 coin 몇개 필요한지 넣어주기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < cardIdx; i++) {
            if(arr[i] < i) pq.add(0);
        }
        
        for(int i = cardIdx; i < n; i++) {
  
            //뽑은 카드 짝만들 수 있을 때 
            if(arr[i] < i && arr[i] < cardIdx) {
                pq.add(1);
            } else if(arr[i] < i && arr[i] >= cardIdx) {
                pq.add(2);
            }
            
            if(i%2 == 1){
                if(!pq.isEmpty()) {
                    int v = pq.poll();
                    if(coin >= v) {
                        coin-=v;
                        answer++;
                    } else break;
                } else break;
            }
        }
        return answer;
    }
}
