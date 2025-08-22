import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < line.length - 1; i++){
            for(int j = 0; j < line.length; j++){
                int[] a = line[i];
                int[] b = line[j];
                int[] point = intersection(a,b);
                if(point[0] != 1001 && point[1] != 1001){
                    list.add(point);
                    minX = Math.min(minX, point[0]);
                    minY = Math.min(minY, point[1]);
                    maxX = Math.max(maxX, point[0]);
                    maxY = Math.max(maxY, point[1]);
                }
                
            }
        }
        
        String[] answer = new String[maxY - minY + 1];


        int width = maxX - minX + 1;
        int height = maxY - minY + 1;

        char[][] grid = new char[height][width];
        for (int r = 0; r < height; r++) {
            Arrays.fill(grid[r], '.');
        }

        for (int[] p : list) {
            int gx = p[0] - minX;
            int gy = maxY - p[1];

            if (gy >= 0 && gy < height && gx >= 0 && gx < width) {
                grid[gy][gx] = '*';
            }
        }

        answer = new String[height];
        for (int r = 0; r < height; r++) {
            answer[r] = new String(grid[r]);
        }

        return answer;
    }
    
    public int[] intersection(int[] a, int[] b){
    long A = a[0], B = a[1], E = a[2];
    long C = b[0], D = b[1], F = b[2];

    long denom = A * D - B * C;
    if (denom == 0) return new int[] {1001, 1001};

    long xNum = B * F - E * D;
    long yNum = E * C - A * F;

    if (xNum % denom != 0 || yNum % denom != 0) return new int[] {1001, 1001};

    long x = xNum / denom;
    long y = yNum / denom;

    return new int[] {(int)x, (int)y};
    }
}