import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> aQue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                return a-b;
            }
            
        });
        PriorityQueue<Integer> dQue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        
        
        for(int i = 0; i < operations.length; i++){
            
            String[] str = operations[i].split(" ");
            
            if(str[0].equals("I")){
                aQue.offer(Integer.parseInt(str[1]));
                dQue.offer(Integer.parseInt(str[1]));
            } else if (aQue.size() > 0) {
                if(Integer.parseInt(str[1]) > 0){
                    int max = dQue.poll();
                    aQue.remove(max);
                } else {
                    int min = aQue.poll();
                    dQue.remove(min);
                }
            }
        }

        if(aQue.size() > 0) {
            answer[1] = aQue.poll();
            answer[0] = dQue.poll();
        }
        
        return answer;
    }
}