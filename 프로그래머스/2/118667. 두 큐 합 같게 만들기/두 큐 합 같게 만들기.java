class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int length = queue1.length;
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        if ((sum1 + sum2) % 2 == 1) return -1;

        long total = (sum1 + sum2) / 2;
        int[] arr = new int[2 * length];

        for (int i = 0; i < length; i++) arr[i] = queue1[i];

        for (int i = 0; i < length; i++) arr[i + length] = queue2[i];

        int m = 0;  
        int n = length;  
        long sum = sum1; 

        while (m < n) {
            if (sum == total||(sum < total && n == 2 * length - 1)) break;

            if (sum > total) {
                sum -= arr[m];
                m++;
            } else if (sum < total) { // q2 -> q1
                sum += arr[n];
                n++;
            } 
            answer++;
        }

        if (sum != total) answer = -1;
        return answer;
    }
}