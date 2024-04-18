class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int score = 0;
        for(int i =0 ; i< arr.length;i++){
            score += arr[i];
        }
        answer = (double)score/arr.length;
        return answer;
    }
}