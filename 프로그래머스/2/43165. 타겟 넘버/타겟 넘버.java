class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public int dfs(int[] numbers, int target, int index, int currentSum) {
        if (index == numbers.length) {
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        
        // 현재 숫자를 더하는 경우
        int plus = dfs(numbers, target, index + 1, currentSum + numbers[index]);
        // 현재 숫자를 빼는 경우
        int minus = dfs(numbers, target, index + 1, currentSum - numbers[index]);

        return plus + minus;
    }
}
