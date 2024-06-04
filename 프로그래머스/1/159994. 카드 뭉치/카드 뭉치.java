import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        String cardComplete1 = card(goal,cards1);
        String cardComplete2 = card(goal,cards2);
        return complete(cardComplete1,cardComplete2);
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
    
    public String complete(String cardComplete1,String cardComplete2){
        if (cardComplete1.equals("No")||cardComplete2.equals("No")) {
            return "No";
        }
        return "Yes";
    }
}