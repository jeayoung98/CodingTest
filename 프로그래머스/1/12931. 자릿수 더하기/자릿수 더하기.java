import java.util.stream.*;
import java.util.*;

public class Solution {
    public int solution(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
            .map(Integer::parseInt)
            .reduce(0,(a,b)->a+b);
    }
}