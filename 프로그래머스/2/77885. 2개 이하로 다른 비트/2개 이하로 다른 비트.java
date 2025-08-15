class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            long currentNum = numbers[i];
            if((currentNum & 1L) == 0){
                answer[i] = currentNum + 1L;
            }else{
                answer[i] = currentNum + 1 + ((currentNum ^ (currentNum + 1)) >>> 2);
            }
        }
        return answer;
    }
}