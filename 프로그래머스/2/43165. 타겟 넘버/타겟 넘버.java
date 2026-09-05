class Solution {
    int t;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        this.t = target;
        dfs(numbers, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int current){
        if(depth == numbers.length){
            if(current == t) answer++;
            return;
        }
            dfs(numbers, depth + 1, current + numbers[depth]);
            dfs(numbers, depth + 1, current - numbers[depth]);
    }
}