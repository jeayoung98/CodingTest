import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        char[] arr = expression.toCharArray();
        List<Long> numList = new ArrayList<>();
        List<String> opList = new ArrayList<>();
        String s = "";
        for (int i = 0; i < arr.length; i++){
            char c = arr[i];
            if(Character.isDigit(c)) {
                s += c;
            } else {
                numList.add(Long.parseLong(s));
                s = "";
                opList.add(String.valueOf(c));
            }
        }
        numList.add(Long.parseLong(s));
        
        Set<String> opSet = new HashSet<>(opList);
        List<String> opUsed = new ArrayList<>(opSet);
        
        List<List<String>> precedences = new ArrayList<>();
        boolean[] used = new boolean[opUsed.size()];
        createPermutation(opUsed, new ArrayList<>(), used, precedences);
        
        for (List<String> precedence : precedences) {
            List<Long> nums = new ArrayList<>(numList);
            List<String> ops = new ArrayList<>(opList);
            
            for (String op : precedence) {
                while (ops.contains(op)) {
                    for (int i = 0; i < ops.size(); i++) {
                        if (ops.get(i).equals(op)) {
                            long a = nums.get(i);
                            long b = nums.get(i + 1);
                            long res = 0;
                            switch(op) {
                                case "+":
                                    res = a + b;
                                    break;
                                case "-":
                                    res = a - b;
                                    break;
                                case "*":
                                    res = a * b;
                                    break;
                            }
                            nums.remove(i);
                            nums.remove(i);
                            nums.add(i, res);
                            ops.remove(i);
                            break;
                        }
                    }
                }
            }
            answer = Math.max(answer, Math.abs(nums.get(0)));
        }
        return answer;
    }
    
    public void createPermutation(List<String> opUsed, List<String> current, boolean[] used, List<List<String>> precedences) {
        if (current.size() == opUsed.size()) {
            precedences.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < opUsed.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(opUsed.get(i));
                createPermutation(opUsed, current, used, precedences);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}
