class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[] sum = new int[score.length];
        for(int i =0;i<score.length;i++){
            sum[i] = score[i][0]+score[i][1];
            }
        int count = 1;
        for(int i = 200; i >= 0; i--){
            int temp = 0;
            for(int j = 0; j < sum.length; j++){
                if(i == sum[j]){
                    answer[j] = count;
                    temp++;
                }
            }count += temp;
        }return answer;
        }
        
    }
