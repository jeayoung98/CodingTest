class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        // 대결할때까지 각각의 번호를 줄임
        while(true){
            // 작은 수가 홀수이고, 차이가 1이여야 대결함
            if(Math.min(a,b) % 2 == 1 && Math.abs(a-b) == 1) break;
            a -= a/2;
            b -= b/2;
            answer++;
        }
        return answer;
    }
}