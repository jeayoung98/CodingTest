import java.util.stream.*;
import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr1[0].length;
        int[][] answer = new int[rows][cols];
        
        IntStream.range(0, rows).forEach(i ->
            IntStream.range(0, cols).forEach(j ->
                answer[i][j] = arr1[i][j] + arr2[i][j]
            )
        );

        return answer;
    }
}
