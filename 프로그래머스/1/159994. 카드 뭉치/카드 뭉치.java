import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        List<String> listCards1 = Arrays.asList(cards1); // indexOf쓰려고
        List<String> listCards2 = Arrays.asList(cards2);

        int lastIndex1 = -1;
        int lastIndex2 = -1;
        int count1 = 0;
        int count2 = 0;
       
        for (String str : goal) { // cards1
            if(listCards1.contains(str)){
                int cardIndex = listCards1.indexOf(str);
                if (cardIndex != lastIndex1 + 1) return "No"; // 건너뛰는지
                lastIndex1 = cardIndex;
                count1++;
            }
            
        }

        for (String str : goal) { // cards2
            if(listCards2.contains(str)){
                int cardIndex = listCards2.indexOf(str);
                if (cardIndex != lastIndex2 + 1) return "No"; // 건너뛰는지
                lastIndex2 = cardIndex;
                count2++;
            }
        }
        return answer;
    }
}