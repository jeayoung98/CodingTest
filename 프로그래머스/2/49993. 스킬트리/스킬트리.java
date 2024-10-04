import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        List<String> skillOrder = Arrays.stream(skill.split(""))
                                        .collect(Collectors.toList());

        return (int) Arrays.stream(skill_trees)
                           .map(tree -> tree.replaceAll("[^" + skill + "]", "")) 
                           .filter(s -> isValidSkillTree(skillOrder, s)) 
                           .count(); 
    }

    private boolean isValidSkillTree(List<String> skillOrder, String s) {
        int lastIdx = -1; 
        for (char ch : s.toCharArray()) {
            int idx = skillOrder.indexOf(String.valueOf(ch));
            if (idx == -1 || idx > lastIdx + 1) {
                return false;
            }
            lastIdx = idx;
        }
        return true;
    }
}
