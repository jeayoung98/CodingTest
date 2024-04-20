class Solution {
    public int solution(int n) {
        int answer = 0;
        String base3 = Integer.toString(n,3);
        StringBuilder sb = new StringBuilder(base3);
        answer = Integer.parseInt(sb.reverse().toString(),3);
        return answer;
    }
}