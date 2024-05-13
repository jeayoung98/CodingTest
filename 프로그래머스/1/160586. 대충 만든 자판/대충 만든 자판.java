class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++){
            answer[i] = count(keymap, targets[i]);
        }
        return answer;
    }
    
    public int count(String[] keymap, String target){
        int total = 0;
        for(int i = 0; i < target.length(); i++){
            int min = 101;
            for(int j = 0; j < keymap.length; j++){
                int index = keymap[j].indexOf(target.charAt(i));
                if(index != -1) min = Math.min(min, index + 1);
            }
            if(min == 101) return -1;
            total += min;
        }
        return total;
    }
}