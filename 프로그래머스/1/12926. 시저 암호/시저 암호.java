class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] ch = s.toCharArray();
        for(char c : ch){
            if((c+"").equals(" ")){
                answer += " ";
            }else if((c + n > 90 && c <= 90) || (c + n > 122 && c <= 122)) answer += (char)(c + n -26);
            else answer += (char)(c+n) +"";
           
        }
        return answer;
    }
}