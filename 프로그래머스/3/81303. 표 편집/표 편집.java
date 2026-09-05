import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] deleted = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }

        next[n - 1] = -1;

        Stack<Integer> stack = new Stack<>();

        int pointer = k;

        for (String c : cmd) {
            char type = c.charAt(0);

            if (type == 'U') {
                int x = Integer.parseInt(c.substring(2));

                while (x-- > 0) {
                    pointer = prev[pointer];
                }

            } else if (type == 'D') {
                int x = Integer.parseInt(c.substring(2));

                while (x-- > 0) {
                    pointer = next[pointer];
                }

            } else if (type == 'C') {
                stack.push(pointer);
                deleted[pointer] = true;

                int up = prev[pointer];
                int down = next[pointer];

                if (up != -1) {
                    next[up] = down;
                }

                if (down != -1) {
                    prev[down] = up;
                }

                if (down != -1) {
                    pointer = down;
                } else {
                    pointer = up;
                }

            } else if (type == 'Z') {
                int z = stack.pop();
                deleted[z] = false;

                int up = prev[z];
                int down = next[z];

                if (up != -1) {
                    next[up] = z;
                }

                if (down != -1) {
                    prev[down] = z;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (boolean isDeleted : deleted) {
            sb.append(isDeleted ? 'X' : 'O');
        }
        
        return sb.toString();
    }
}