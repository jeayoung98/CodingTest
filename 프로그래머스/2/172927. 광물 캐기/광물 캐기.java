import java.util.*;

class Solution {
    int picksCount = 0;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        for(int i = 0; i < picks.length; i++){
            picksCount += picks[i];
        }
        String[][] mineralArr = new String[minerals.length / 5 + 1][5];
        
        for(int i = 0; i < minerals.length; i++){
            mineralArr[i / 5][i % 5] = minerals[i];
        }
        
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i = 0; i < ((picksCount < minerals.length / 5 + 1) ? picksCount : minerals.length / 5 + 1); i++){
            queue.add(setPoint(mineralArr[i], i));
        }
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentIndex = current[1];

            int currentPick = -1;
            for(int i = 0; i < 3; i++){
                if(picks[i] > 0){
                    currentPick = i;
                    picks[i]--;
                    break;
                }
            }

            for(int i = 0; i < 5; i++){
                String currentMineral = mineralArr[currentIndex][i];
                if(currentMineral == null) break;

                if(currentMineral.equals("diamond")){
                    if(currentPick == 0) answer += 1;
                    else if(currentPick == 1) answer += 5;
                    else answer += 25;
                }
                else if(currentMineral.equals("iron")){
                    if(currentPick == 0) answer += 1;
                    else if(currentPick == 1) answer += 1;
                    else answer += 5;
                }
                else {
                    if(currentPick == 0) answer += 1;
                    else if(currentPick == 1) answer += 1;
                    else answer += 1;
                }
            }
        }
        
        return answer;
    }
    
    public int[] setPoint(String[] arr, int index){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == null) break;
            
            if(arr[i].equals("diamond")) sum += 31;
            else if(arr[i].equals("iron")) sum += 6;
            else sum += 1; 
        }
        return new int[] {sum, index};
    }
}