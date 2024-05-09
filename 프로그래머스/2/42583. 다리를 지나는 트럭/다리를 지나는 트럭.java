import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int[] bridge = new int[bridge_length];
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < truck_weights.length; i++) {
            queue.add(truck_weights[i]);
        }
        
        int curWeight = 0;
        while(!queue.isEmpty()) {
            answer+=1;
            curWeight-=bridge[bridge_length-1];
            for(int i = bridge_length-2; i >=0; i--) {
                bridge[i+1] = bridge[i];
            }
            bridge[0] = 0;
            int num = queue.peek();
            if(num+curWeight > weight) continue;
            bridge[0] = num;
            curWeight+=queue.poll();
        }
        
        for(int i = 0; i < bridge_length; i++) {
            if(bridge[i] != 0) {
                answer+=bridge_length-i;
                break;
            }
        }
        return answer;
    }
}