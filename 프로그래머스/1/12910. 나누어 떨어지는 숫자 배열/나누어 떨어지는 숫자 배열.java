import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] intArr = Arrays.stream(arr)
                             .filter(a -> a % divisor == 0)
                             .sorted()
                             .toArray();
        
        return intArr.length == 0 ? new int[] {-1} : intArr;
    }
}