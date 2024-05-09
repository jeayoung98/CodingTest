import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n];
        Arrays.fill(clothes, 1);

        for (int r : reserve)
            clothes[r-1] ++;
        for (int l : lost)
            clothes[l-1] --;

        for (int i = 0; i < n; i++) {
            if (clothes[i] >= 1) {
                answer++;
            } else { 
                // 왼쪽 여분
                if (i >= 1 && clothes[i - 1] == 2) { 
                    clothes[i - 1]--;
                    clothes[i]++;
                    answer++;
                // 오른쪽 여분
                } else if (i < n-1 && clothes[i + 1] == 2) { 
                    clothes[i + 1]--;
                    clothes[i]++;
                    answer++;
                }
            }
        }

        return answer;
    }
}