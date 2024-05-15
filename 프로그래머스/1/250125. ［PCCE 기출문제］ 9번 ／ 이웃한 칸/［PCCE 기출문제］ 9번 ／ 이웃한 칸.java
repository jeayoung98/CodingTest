import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for(int i = h - 1; i <= h + 1; i++){
            for(int j = w - 1; j <= w + 1; j++){
                try{
                    if(i == h || j == w){
                        if(board[h][w].equals(board[i][j])) answer++;
                        System.out.println(i+" "+j);
                    } 
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                    System.out.println(i+" "+j);
                }
            }
        }
        return answer - 1;
    }
}