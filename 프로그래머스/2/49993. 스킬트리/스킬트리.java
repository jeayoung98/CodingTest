import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Deque<String> deque = new ArrayDeque<>();
        for(int i = 0; i < skill.length(); i++){
            deque.add(skill.charAt(i)+"");
        }
        for(int i = 0; i < skill_trees.length; i++){
            String str = skill_trees[i].replaceAll("[^" + skill + "]", "");
            System.out.println(str);
            skill_trees[i] = str;
            if(str.isEmpty()) answer++;
        }
        String k = "";
        while(!deque.isEmpty()){
            k += deque.removeFirst();
            for(int i = 0; i < skill_trees.length; i++){
                if(skill_trees[i].equals(k)) answer++;
            }
            
        }
        return answer;
    }
}