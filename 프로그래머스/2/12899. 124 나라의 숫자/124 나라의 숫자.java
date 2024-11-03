public class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3;
            answer.append(remainder);
            n = (n - 1) / 3; 
        }
        answer.reverse();

        return answer.toString().replaceAll("0","4");
    }
}
