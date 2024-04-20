class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] ch = s.toCharArray();
        for(char c : ch){
            if((c+"").equals(" ")){
                answer += " ";
            }else if(((int)c + n > 90 && (int)c <= 90) || ((int)c + n > 122 && (int)c <= 122)) answer += (char)((int)c + n -26);
            else answer += (char)((int)c+n) +"";
           
        }
        return answer;
    }
}