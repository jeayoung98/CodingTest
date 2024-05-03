import java.util.regex.*;
class Solution {
    public static int solution(String dartResult) {
        int answer = 0;
        String str = "(\\d+)(S|D|T)(\\*|#)?"; // ? 는 앞에 요소가 0번 또는 1번 \\d+는 숫자가 여러개
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(dartResult);
        int[] total = new int[3];
        int count = 0;
        while (matcher.find()) {
            int score = Integer.parseInt(matcher.group(1));
            String bonus = matcher.group(2);
            String option = matcher.group(3);
            total[count] = score(score,bonus);
            if(option != null){
                if (option.equals("*")) {
                    if(count == 0){
                        total[count] *= 2;
                    }else {
                        total[count] *=2;
                        total[count-1] *= 2;
                }
                }
                else if (option.equals("#")) total[count] *= -1;
            }count++;
        }
        answer = total[0] + total[1] + total[2];
        return answer;
    }
    public static int score(int score, String bonus){
        int num = 0;
        if(bonus.equals("S"))  num = (int) Math.pow(score, 1);
        else if(bonus.equals("D")) num = (int) Math.pow(score,2);
        else if(bonus.equals("T")) num = (int) Math.pow(score,3);
        return num;
    }
}
