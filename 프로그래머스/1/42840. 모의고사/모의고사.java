import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] dropMath1 = {1, 2, 3, 4, 5};
        int[] dropMath2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] dropMath3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] count = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == dropMath1[i % dropMath1.length]) count[0]++;
            if(answers[i] == dropMath2[i % dropMath2.length]) count[1]++;
            if(answers[i] == dropMath3[i % dropMath3.length]) count[2]++;
        }
        
        int maxScore = Math.max(count[0], Math.max(count[1], count[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(count[0] == maxScore) list.add(1);
        if(count[1] == maxScore) list.add(2);
        if(count[2] == maxScore) list.add(3);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}