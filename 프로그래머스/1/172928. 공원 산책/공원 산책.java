import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int width = park[0].length();
        int height = park.length;
        Set<String> map = new HashSet<>();
        int[] current = new int[2];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (park[i].charAt(j) == 'S') {
                    current[0] = i;
                    current[1] = j;
                }
                if (park[i].charAt(j) == 'X') {
                    map.add(i + "," + j);
                }
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0];
            int move = Integer.parseInt(parts[1]);

            int X = current[0];
            int Y = current[1];
            boolean canMove = true;

            for (int j = 1; j <= move; j++) {
                switch (direction) {
                    case "E":
                        Y = current[1] + j;
                        break;
                    case "W":
                        Y = current[1] - j;
                        break;
                    case "S":
                        X = current[0] + j;
                        break;
                    case "N":
                        X = current[0] - j;
                        break;
                }
                if (X < 0 || X >= height || Y < 0 || Y >= width || map.contains(X + "," + Y)) {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                switch (direction) {
                    case "E":
                        current[1] += move;
                        break;
                    case "W":
                        current[1] -= move;
                        break;
                    case "S":
                        current[0] += move;
                        break;
                    case "N":
                        current[0] -= move;
                        break;
                }
            }
        }

        answer[0] = current[0];
        answer[1] = current[1];
        return answer;
    }
}
