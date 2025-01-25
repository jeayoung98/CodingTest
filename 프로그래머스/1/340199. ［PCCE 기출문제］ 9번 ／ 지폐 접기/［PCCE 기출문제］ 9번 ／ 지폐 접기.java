import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        Arrays.sort(bill);
        int walletX = wallet[0];
        int walletY = wallet[1];
        
        int billX = bill[0];
        int billY = bill[1];
        while(walletX < billX || walletY < billY){
            if(billY > billX) {
                billY /= 2;
            }
            else {
                billX /= 2;
            }
            answer++;
            if(billX > billY){
                int temp = billX;
                billX = billY;
                billY = temp;
            }
        }
        return answer;
    }
}