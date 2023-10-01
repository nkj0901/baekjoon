class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int carpet = brown + yellow;
        
        if(yellow == 1) {
            answer[0] = 3; answer[1] = 3;
        } else {
            for(int i = 1; i <= Math.sqrt(yellow); i++) {
                if(yellow%i != 0) continue;
                int garo = yellow/i;
                if((i+2)*(garo+2) == carpet){
                    answer[0] = garo+2;
                    answer[1] = i+2;
                    break;
                }
            }
        }                
        return answer;
    }
}