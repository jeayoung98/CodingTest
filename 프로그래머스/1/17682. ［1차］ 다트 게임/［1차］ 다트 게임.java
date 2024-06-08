import java.util.regex.*;
import java.util.stream.*;

class Solution {
    public int solution(String dartResult) {
        String pattern = "(\\d+)([SDT])([*#]?)";
        Matcher matcher = Pattern.compile(pattern).matcher(dartResult);
        int[] scores = new int[3];
        int index = 0;

        while (matcher.find()) {
            int score = Integer.parseInt(matcher.group(1));
            String bonus = matcher.group(2);
            String option = matcher.group(3);
            scores[index] = calculateScore(score, bonus);

            if (option.equals("*")) {
                scores[index] *= 2;
                if (index > 0) {
                    scores[index - 1] *= 2;
                }
            } else if (option.equals("#")) {
                scores[index] *= -1;
            }
            index++;
        }
        return IntStream.of(scores).sum();
    }

    public int calculateScore(int score, String bonus) {
        switch (bonus) {
            case "D":
                return (int) Math.pow(score, 2);
            case "T":
                return (int) Math.pow(score, 3);
            default:
                return score;
        }
    }
}