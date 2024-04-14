class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        if(isParallel(dots, 0, 1, 2, 3) || isParallel(dots, 0, 2, 1, 3) || isParallel(dots, 0, 3, 1, 2)){
            answer = 1;
        }
        return answer;
    }
    
    public double inclination(int[][] dots, int a, int b){
        return (double)(dots[a][1] - dots[b][1]) / (dots[a][0] - dots[b][0]);
    }
    
    public boolean isParallel(int[][] dots, int a, int b, int c, int d){
        return inclination(dots, a, b) == inclination(dots, c, d);
    }
}