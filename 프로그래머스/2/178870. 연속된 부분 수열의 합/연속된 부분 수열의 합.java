class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0, end = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (end < sequence.length) {
            sum += sequence[end++];
            
            while (sum >= k) {
                if (sum == k) {
                    if (min > end - start) {
                        min = end - start;
                        answer[0] = start;
                        answer[1] = end - 1;
                    }
                }
                sum -= sequence[start++];
            }
        }
        
        return answer;
    }
}
