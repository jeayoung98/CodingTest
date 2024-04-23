class Solution {
    public int solution(int slice, int n) {
        int answer = 1;
        while(true){
            if(1<=(slice * answer / n)){
                break;
            }else answer++;
        }
        return answer;
    }
}