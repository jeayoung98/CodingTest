class Solution {
    public int[] solution(int num, int total) {
        int range = (total/num) - (num/2);

        int[] answer = new int[num];

        for (int i = range; i < range + num; i++) {
            int sum = sum(i,i + num - 1);
            if (sum == total) {
                for (int j = 0; j < answer.length; j++,i++) {
                    answer[j] = i;
                }break;
            }
        }
        
        return answer;
    }
    
    public int sum(int num1, int num2) {
        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            sum += i;
        }return sum;
    }
}