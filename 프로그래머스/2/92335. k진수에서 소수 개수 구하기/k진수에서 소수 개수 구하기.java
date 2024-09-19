class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n,k);
        String[] arr = str.split("0+");
        for(int i = 0 ; i < arr.length; i++){
            if(isPrime(Long.parseLong(arr[i]))) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(long i){
        if(i == 2) return true;
        if(i == 1 || i % 2 == 0) return false;
        for(int j = 3; j < Math.sqrt(i) + 1; j+=2){
            if(i % j == 0) return false;
        }
        return true;
    }
}