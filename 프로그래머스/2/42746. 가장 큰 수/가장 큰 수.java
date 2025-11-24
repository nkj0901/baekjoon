import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        int N = numbers.length;
        
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }        
        
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();   
        for(String a : arr) sb.append(a);
        
        if(arr[0].equals("0")) return "0";
            
        return sb.toString();
    }
}