import java.util.*;

public class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int x = 0, y = 0;

        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y;

            if (dir == 'U' && y < 5) ny++;
            else if (dir == 'D' && y > -5) ny--;
            else if (dir == 'R' && x < 5) nx++;
            else if (dir == 'L' && x > -5) nx--;

            if (nx != x || ny != y) { 
                String path1 = x + "," + y + "," + nx + "," + ny;
                String path2 = nx + "," + ny + "," + x + "," + y;
                set.add(path1);
                set.add(path2);
                
                x = nx;
                y = ny;
            }
        }
        return set.size() / 2;
    }
}
