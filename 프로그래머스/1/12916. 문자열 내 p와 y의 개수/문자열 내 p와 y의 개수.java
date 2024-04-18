class Solution {
    boolean solution(String s) {
        int count = 0;
        String lower = s.toLowerCase();
        for(int i = 0; i< lower.length(); i++){
            if(lower.charAt(i) == 'p'){
                count += 1;
            }
            if(lower.charAt(i) == 'y'){
                count -= 1;
            }
        }
        return count == 0 ? true:false;
    }
}