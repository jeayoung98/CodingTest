class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i = 0;i < my_string.length();i++){
            for(int j = 1;j<10;j++){
                if((my_string.charAt(i)+"").equals(String.valueOf(j))){
                    answer +=j;
                }
            }
        }
        return answer;
    }
}