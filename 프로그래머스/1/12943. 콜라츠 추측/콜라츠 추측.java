class Solution {
    public int solution(long num) {
        int answer = 0;
        while(answer <= 500){
            if(num == 1){
                break;
            }else{
                if(num % 2 == 0){
                    num /= 2;
                }else num = num * 3 +1;
            }
            answer++;
        }
        if(answer >= 500){
            return -1;
        }
        return answer;
    }
}