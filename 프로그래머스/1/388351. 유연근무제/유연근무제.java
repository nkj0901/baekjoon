class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int sun = 7-startday;
        int sat = sun == 0 ? 6 : sun-1;
        
        loop: for(int i = 0; i < schedules.length; i++) {
            for(int j = 0; j < 7; j++) {
                if(j == sun || j == sat) continue;
                
                int limit = schedules[i] + 10;   
                if(limit%100/60 > 0) limit = limit + 100 - 60;
                if(limit < timelogs[i][j]) continue loop;
            }
            answer++;
        }
        
        return answer;
    }
}