import java.util.*;

class Solution {
    public String solution(String str) {
        str = str.replaceAll("\\s+", "");
        String answer = "";
        int coe = 0; // 계수
        int con = 0; // 상수

        // '+' 기호를 기준으로 문자열 분할
        String[] parts = str.split("\\+");
        for (String part : parts) {
            if (part.isEmpty()) {
                // 아무 값도 없으면 건너뜀
                continue;
            }
            
            if (part.contains("x")) { // x가 있을때
                int xIndex = part.indexOf("x");
                String coeStr = part.substring(0, xIndex);
                if (coeStr.isEmpty()) {
                    // 계수가 없으면 1로 처리
                    coe += 1;
                } else {
                    coe += Integer.parseInt(coeStr);
                }
            } else { // 상수
                con += Integer.parseInt(part);
            }
        }
        
        if(coe == 1){
            answer = "x";
        }else answer = coe + "x";

        
        if (con != 0) {
            if (coe == 0) {
                answer = String.valueOf(con);
            } else {
                answer += " + " + con;
            }
        }

        return answer;
    }
}