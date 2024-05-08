class Solution {
    public int[] solution(int[] array) {
        int max = 0;
        int[] answer = new int[2];
        for(int i = 0;i < array.length;i++){
            if(max < array[i]){
                max = array[i];
            }
        }for(int j =0;j<array.length;j++){
            if(max == array[j]){
                answer[1]=j;
            }
        }
        answer[0] = max;
        return answer;
    }
}