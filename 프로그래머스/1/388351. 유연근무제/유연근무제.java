class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i < schedules.length; i++){
            int wantTime = schedules[i];
            boolean isTrue = true;
            int currentDay = startday;
            for(int j = 0; j < 7; j++){
                if(!checkTime(wantTime, timelogs[i][j]) && currentDay != 6 && currentDay != 7){
                    isTrue = false;
                    break;
                } 
                currentDay++;
                currentDay =  currentDay / 8 + currentDay % 8;
            }
            if(isTrue) answer++;
        }
        return answer;
    }
    
    public boolean checkTime(int wantTime, int arrive){
        int hour = wantTime / 100;
        int min = wantTime % 100;
        
        if(min >= 50){
            hour++;
            min = min - 50;
        }else min += 10;
        
        if(hour * 100 + min >= arrive) return true;
        return false;
    }
}