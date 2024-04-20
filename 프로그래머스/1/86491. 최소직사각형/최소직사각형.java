import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i = 0; i < sizes.length; i++){
            int min = Math.min(sizes[i][0],sizes[i][1]);
            int max = Math.max(sizes[i][0],sizes[i][1]);
            sizes[i][0] = min;
            sizes[i][1] = max;
        }
        int rowMax = sizes[0][0];
        int colMax = sizes[0][1];
        for(int i = 0; i < sizes.length; i++){
            if(rowMax < sizes[i][0]) rowMax = sizes[i][0];
            if(colMax < sizes[i][1]) colMax = sizes[i][1]; 
        }
        answer = rowMax * colMax;
        return answer;
    }
}