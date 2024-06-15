class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        while(true){
            if(Math.min(a,b) % 2 == 1 && Math.abs(a-b) == 1) break;
            a = win(a);
            b = win(b);
            answer++;
        }
        return answer;
    }
    
    public int win(int x){
        if(x % 2 != 0){
            x -= x/2;
        }else x-= x/2;
        return x;
    }
}