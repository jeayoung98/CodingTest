class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] dic =  {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            for (String str1 : dic) {
                if (babbling[i].contains(str1)) {
                    babbling[i] = babbling[i].replace(str1, "1");
                }
            }
        }
        for(String str : babbling){
            if(isNum(str)){
                answer+=1;
            }
        }
        return answer;
    }
    
    public static boolean isNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}