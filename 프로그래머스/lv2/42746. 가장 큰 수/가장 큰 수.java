import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int N = numbers.length;
        String[] arr = new String[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = numbers[i]+"";
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b){
                //마이너스를 리턴하면 앞에 있는 것이 사전적을 앞에 있다는 소리
                return((b+a).compareTo(a+b));
            }
        });
        if(Integer.parseInt(arr[0]) == 0) return "0"; 
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}