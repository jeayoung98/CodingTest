class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        for(int i = code-1;i<cipher.length();i+=code){
            sb.append(cipher.charAt(i));
            }answer += sb;
        return answer;
    }
}