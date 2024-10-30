class Solution {
    private String str;
    private int result;

    public int solution(int storey) {
        this.str = Integer.toString(storey);
        this.result = Integer.MAX_VALUE;
        int n = str.length();
        dfs(n - 1, 0, 0);
        return result;
    }
    private void dfs(int cursor, int offset, int score) {
        if (cursor == -1) {
            result = Math.min(result, score + offset);
            return;
        }
        int num = Character.getNumericValue(str.charAt(cursor)) + offset;
        dfs(cursor - 1, 0, score + num);
        dfs(cursor - 1, 1, score + 10 - num);
    }
}