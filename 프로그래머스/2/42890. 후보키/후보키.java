import java.util.*;

class Solution {
    int row, col;
    String[][] arr;
    List<List<Integer>> list = new ArrayList<>();
    List<List<Integer>> list2 = new ArrayList<>();
    public int solution(String[][] relation) {
        arr = relation;
        row = relation.length;
        col = relation[0].length;
        
        for (int size = 1; size <= col; size++) {
            dfs(0, new ArrayList<>(), size);
        }
        
        minfilter();
        
        return list2.size();
    }
    
    public void dfs(int start, List<Integer> combination, int end) {
        if (combination.size() == end) {
            if (isUnique(combination)) {
                list.add(new ArrayList<>(combination));
            }
            return;
        }
        
        for (int i = start; i < col; i++) {
            combination.add(i);
            dfs(i + 1, combination, end);
            combination.remove(combination.size() - 1);
        }
    }
    
    // 유일성
    public boolean isUnique(List<Integer> combination) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j : combination) {
                sb.append(arr[i][j]).append(" ");
            }
            if (!set.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }
    
    // 최소성
    public void minfilter(){
        for (List<Integer> combi : list) {
            boolean isMin = true;
            for (List<Integer> combi2 : list2) {
                if (combi.containsAll(combi2)) {
                    isMin = false;
                    break;
                }
            }
            if (isMin) {
                list2.add(combi);
            }
        }
    }
}
