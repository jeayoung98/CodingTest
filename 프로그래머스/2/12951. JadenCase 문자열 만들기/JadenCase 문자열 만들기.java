import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ",-1);
        
        String[] capitalizedArr = Arrays.stream(strArr)
                .map(str -> {
                    String lowerStr = str.toLowerCase();
                    return IntStream.range(0, lowerStr.length())
                            .mapToObj(i -> i == 0 ? String.valueOf(Character.toUpperCase(lowerStr.charAt(i))) : String.valueOf(lowerStr.charAt(i)))
                            .collect(Collectors.joining());
                })
                .toArray(String[]::new);
        
        return String.join(" ", capitalizedArr);
    }
}
