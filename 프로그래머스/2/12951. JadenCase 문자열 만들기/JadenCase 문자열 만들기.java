import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        char[] blankArr = sb.reverse().toString().toCharArray();
        StringBuilder blank = new StringBuilder();
        for(char c : blankArr){
            if(Character.isLetter(c)) break;
            if(c == ' ') blank.append(c+"");
        }
        String[] strArr = s.split(" ");
        
        String[] capitalizedArr = Arrays.stream(strArr)
                .map(str -> {
                    String lowerStr = str.toLowerCase();
                    return IntStream.range(0, lowerStr.length())
                            .mapToObj(i -> i == 0 ? String.valueOf(Character.toUpperCase(lowerStr.charAt(i))) : String.valueOf(lowerStr.charAt(i)))
                            .collect(Collectors.joining());
                })
                .toArray(String[]::new);
        
        return String.join(" ", capitalizedArr) + blank.toString();
    }
}
