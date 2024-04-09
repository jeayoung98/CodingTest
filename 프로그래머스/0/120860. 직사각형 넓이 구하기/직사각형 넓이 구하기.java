class Solution {
    public int solution(int[][] dots) { // 가로 0, 세로 1
        return area(dots, 0) * area(dots, 1);
    }
    
    public int area(int[][] dots, int n) {
        int max = dots[0][n];
        int min = dots[0][n];
        for (int i = 1; i < 4; i++) {
            if (max < dots[i][n]) {
                max = dots[i][n];
            } else if (min > dots[i][n]) {
                min = dots[i][n];
            }
        }
        return max - min;
    }
}
