import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String capital = "";
        for(int i =0 ; i < s.length() ; i++){
            if((int)s.charAt(i) < 97) capital += s.charAt(i)+"";
            else answer += s.charAt(i) +"";
        }
        return strSort(answer) + strSort(capital);
    }
    public String strSort(String str){
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        return new StringBuilder(new String(strArr)).reverse().toString();
    }
}