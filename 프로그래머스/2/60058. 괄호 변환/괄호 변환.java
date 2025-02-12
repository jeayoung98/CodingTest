import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return p;

        int index = splitIndex(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        if (isValid(u)) {
            return u + solution(v);
        } else {
            String answer = "";
            answer += "(" + solution(v) + ")";
            answer += reverse(u.substring(1, u.length() - 1));
            return answer;
        }
    }

    public int splitIndex(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count == 0) return i + 1;
        }
        return s.length();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public String reverse(String s) {
        String result = "";
        for (char c : s.toCharArray()) {
            result += (c == '(') ? ")" : "(";
        }
        return result;
    }
}