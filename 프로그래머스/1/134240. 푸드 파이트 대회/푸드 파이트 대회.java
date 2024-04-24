class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int cal = 1;
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i]/2 ; j++){
                sb.append(cal);
            }
            cal++;
        }
        
        answer = sb.toString()+"0";
        answer += sb.reverse().toString();
        return answer;
    }
}