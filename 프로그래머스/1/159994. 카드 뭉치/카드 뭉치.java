import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        card(goal,cards1);
        card(goal,cards2);
        if (card(goal, cards1).equals("No") || card(goal, cards2).equals("No")) {
            answer = "No";
        }
        return answer;
    }
    public String card(String[] goal,String[] list){
        List<String> listCards = Arrays.asList(list);
        int lastIndex = -1;
        int count = 0;
        for (String str : goal) { 
            if(listCards.contains(str)){
                int cardIndex = listCards.indexOf(str);
                if (cardIndex != lastIndex + 1) return "No";
                lastIndex = cardIndex;
                count++;
            }
        }return "Yes";
    }
}