import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = num++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotation(arr, queries[i]);
        }

        return answer;
    }

    public int rotation(int[][] arr, int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        List<Integer> list = new ArrayList<>();

        for (int i = y1; i <= y2; i++) {
            list.add(arr[x1][i]);
        }
        for (int i = x1 + 1; i <= x2 - 1; i++) {
            list.add(arr[i][y2]);
        }
        if (x2 > x1) {
            for (int i = y2; i >= y1; i--) {
                list.add(arr[x2][i]);
            }
        }
        if (y2 > y1) {
            for (int i = x2 - 1; i >= x1 + 1; i--) {
                list.add(arr[i][y1]);
            }
        }

        int lastValue = list.remove(list.size() - 1);
        list.add(0, lastValue);

        int index = 0;

        for (int i = y1; i <= y2; i++) {
            arr[x1][i] = list.get(index++);
        }
        for (int i = x1 + 1; i <= x2 - 1; i++) {
            arr[i][y2] = list.get(index++);
        }
        if (x2 > x1) {
            for (int i = y2; i >= y1; i--) {
                arr[x2][i] = list.get(index++);
            }
        }
        if (y2 > y1) {
            for (int i = x2 - 1; i >= x1 + 1; i--) {
                arr[i][y1] = list.get(index++);
            }
        }

        int min = Collections.min(list);

        return min;
    }
}
