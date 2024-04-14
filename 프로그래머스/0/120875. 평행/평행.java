class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        double[][] inclination = new double[3][2];
        int x = 0;
        for (int i = 1; i <= dots.length-1; i++) {
            for (int j = 1; j <= dots.length-1; j++) {
                if (j != i) {
                    for (int k = 1; k <= dots.length-1; k++) {
                        if (k != i && k != j) {
                            inclination[x][0] = (double)(dots[0][1]-dots[i][1])/(dots[0][0]-dots[i][0]);
                            inclination[x][1] = (double)(dots[j][1]-dots[k][1])/(dots[j][0]-dots[k][0]);
                                x++;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        for(int i = 0 ; i<inclination.length;i++){
                if(inclination[i][0] == inclination[i][1]){
                    answer = 1;
                }
        }
        return answer;
    }
}