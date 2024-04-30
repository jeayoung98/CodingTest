import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (factors(i) > limit) {
                answer += power;
            } else {
                answer += factors(i);
            }
        }
        return answer;
    }
    
    public int factors(int num) {
        int count = 0; 
        for (int i = 1; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) { 
                if (i == num / i) {
                    count++;
                } else {
                    count += 2;
            }
        }
    }
    return count;
    }
}