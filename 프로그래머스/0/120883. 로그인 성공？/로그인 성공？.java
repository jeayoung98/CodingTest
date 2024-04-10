class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String id = id_pw[0];
        String pw = id_pw[1];
        String answer = "fail";
        for (String[] idpw : db) {
            if (idpw[0].equals(id)) {
                if (idpw[1].equals(pw)) {
                    answer = "login";
                } else {
                    answer = "wrong pw";
                }
            }
        }
        
        return answer;
    }
}