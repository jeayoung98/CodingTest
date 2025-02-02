import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        List<Integer> factorsA = findFactors(gcdA);
        List<Integer> factorsB = findFactors(gcdB);
        
        Collections.sort(factorsA, Collections.reverseOrder());
        Collections.sort(factorsB, Collections.reverseOrder());
        
        int candidateA = 0;
        for (int factor : factorsA) {
            boolean valid = true;
            for (int num : arrayB) {
                if (num % factor == 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                candidateA = factor;
                break;
            }
        }
        
        int candidateB = 0;
        for (int factor : factorsB) {
            boolean valid = true;
            for (int num : arrayA) {
                if (num % factor == 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                candidateB = factor;
                break;
            }
        }
        
        answer = Math.max(candidateA, candidateB);
        return answer;
    }
    
    public List<Integer> findFactors(int x) {
        List<Integer> list = new ArrayList<>();
        int sqrtX = (int)Math.sqrt(x);
        for (int i = 1; i <= sqrtX; i++) {
            if (x % i == 0) {
                list.add(i);
                if (i != x / i) {
                    list.add(x / i);
                }
            }
        }
        return list;
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}