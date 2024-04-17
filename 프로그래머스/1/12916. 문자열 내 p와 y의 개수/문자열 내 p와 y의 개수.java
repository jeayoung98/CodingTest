class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;
        String lower = s.toLowerCase();
        for(int i = 0; i< lower.length(); i++){
            if(lower.charAt(i) == 'p'){
                p += 1;
            }
            if(lower.charAt(i) == 'y'){
                y += 1;
            }
        }
        if(p != y){
            answer = false;
        }
        

        return answer;
    }
}