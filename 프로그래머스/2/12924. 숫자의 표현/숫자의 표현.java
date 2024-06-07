class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int j = 0;
            int k = 0;
            while(j <= n){
                if(j == n){
                    answer++;
                    break;
                }
                j += i+k;
                k++;
            }
        }
        return answer;
    }
}