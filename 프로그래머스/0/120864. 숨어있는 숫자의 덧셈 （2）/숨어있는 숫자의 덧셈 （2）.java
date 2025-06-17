class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char[] arr = my_string.toCharArray();
        int num = 0;
        for(char c : arr){
            if(Character.isDigit(c)) {
                num = num * 10 + Integer.parseInt(c+"");
            }else {
                answer += num;
                num = 0;
            }
        }
        answer += num;
        return answer;
    }
}