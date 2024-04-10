class Solution {
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int denom = LCD(denom1, denom2); // 분모
        int numer = LCD(denom1, denom2) / denom1 * numer1 + LCD(denom1,denom2) / denom2 * numer2; // 분자
        
        int Num = numer / GCD(numer, denom);
        int Den = denom / GCD(numer, denom);
        
        int[] answer = new int[]{Num, Den};
        
        
        return answer;
    }

    public int GCD(int num1,int num2){ // 최대 공약수

        if (num1 % num2 == 0) {
            return num2;
        }
        return GCD(num2, num1 % num2);

    }
    public int LCD(int num1, int num2){ // 최소 공배수
        return num1 * num2 / GCD(num1, num2);
    }
}