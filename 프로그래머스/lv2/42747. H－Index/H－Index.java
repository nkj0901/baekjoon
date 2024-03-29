import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        
        for(int i = 0; i < citations.length; i++){
            if( arr[i] < i+1){
                break;
            }
            answer++;
        }
        
        return answer;
    }
}