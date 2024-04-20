import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int rowMax = 0;
        int colMax = 0;
        for (int[] size : sizes) {
            rowMax = Math.max(rowMax, Math.max(size[0], size[1]));
            colMax = Math.max(colMax, Math.min(size[0], size[1]));
        }
        return rowMax * colMax;
    }
}