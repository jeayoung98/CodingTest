class Solution {
    public int solution(int chicken) {
        if(chicken % 9 ==0 && chicken != 0){
            return (chicken/9)-1;
        }
        return chicken/9;
    }
}