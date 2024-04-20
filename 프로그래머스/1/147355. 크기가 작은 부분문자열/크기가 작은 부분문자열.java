class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long length = p.length();
        for (int i = 0; i <= t.length() - length; i++) {
            if (Long.parseLong(t.substring(i, i + (int) length)) <= Long.parseLong(p)) answer++;
        }
        return answer;
    }
}