public class Solution {
    public String solution(int a, int b) {
        String[] Week = {"FRI", "SAT","SUN", "MON", "TUE", "WED", "THU"};
        int[] Month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  
        int total = b;
        for (int i = 0; i < a - 1; i++) {
            total += Month[i];
        }
        int day = (total - 1) % 7;

        return Week[day];
    }
}