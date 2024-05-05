class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        for(int i =0; i<rsp.length();i++){
            if((rsp.charAt(i)+"").equals("2")){
                sb.append("0");
            }
            else if((rsp.charAt(i)+"").equals("0")){
                sb.append("5");
            }
            else if((rsp.charAt(i)+"").equals("5")){
                sb.append("2");
            }
        }answer +=sb;
        return answer;
    }
}