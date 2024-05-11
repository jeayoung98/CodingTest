class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char currentChar = my_string.charAt(i);
            if (Character.isLowerCase(currentChar)) {
                sb.append(Character.toUpperCase(currentChar));
            } else if (Character.isUpperCase(currentChar)) {
                sb.append(Character.toLowerCase(currentChar));
            } else {
                sb.append(currentChar);
            }
        }
            answer += sb;
        
        
        return answer;
    }
}