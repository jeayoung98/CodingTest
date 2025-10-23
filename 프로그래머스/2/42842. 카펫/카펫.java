class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        int a = brown / 2 + 2;
        for(int i = a; i >= 3; i--){
            int j = a - i;
            if(j > 0 && i >= j && i * j == total) answer = new int[] {i,j};
        }
        return answer;
    }
}