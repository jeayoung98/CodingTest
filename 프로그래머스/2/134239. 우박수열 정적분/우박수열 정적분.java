import java.util.*;

class Solution {
    class Point {
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Point> points = new ArrayList<>();
        int step = 0;
        points.add(new Point(step, k));
        int current = k;
        while(current != 1) {
            current = (current % 2 == 0) ? current / 2 : current * 3 + 1;
            points.add(new Point(++step, current));
        }
        
        double[] areas = new double[points.size()];
        areas[0] = 0.0;
        for (int i = 0; i < points.size() - 1; i++) {
            int y1 = points.get(i).y;
            int y2 = points.get(i + 1).y;
            double area = (y1 + y2) / 2.0;
            areas[i + 1] = areas[i] + area;
        }
        
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            int right = points.size() - 1 + b;
            if(a > right) {
                answer[i] = -1.0;
            } else {
                answer[i] = areas[right] - areas[a];
            }
        }
        
        return answer;
    }
}
