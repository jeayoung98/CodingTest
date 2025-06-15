import java.util.*;

public class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Arrays.sort(mats);
        for (int k = mats.length - 1; k >= 0; k--) {
            answer = mats[k];
            if (canPlace(answer, park)) {
                return answer;
            }
        }
        return -1;
    }

    public boolean canPlace(int size, String[][] park) {
        int x = park.length;
        int y = park[0].length;
        for (int i = 0; i <= x - size; i++) {
            for (int j = 0; j <= y - size; j++) {
                if (isSquare(i, j, size, park)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSquare(int x, int y, int size, String[][] park) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
