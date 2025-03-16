import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        String[][] arr = new String[board.length][board[0].length()];
        int oCount = 0;
        int xCount = 0;
        for(int i = 0; i < board.length; i++){
            String[] s = board[i].split("");
            for(int j = 0; j < board[0].length(); j++){
                arr[i][j] = s[j];
                if(s[j].equals("O")) oCount++;
                if(s[j].equals("X")) xCount++;
            }
        }
        System.out.println(whoWins(arr));
        int result = whoWins(arr);
        if(result == 0) answer = 0;
        else if(result == 1){
            if(oCount - xCount == 1) answer = 1;
            else answer = 0;
        } 
        else if(result == 2){
            if(oCount == xCount) answer = 1;
            else answer = 0;
        }
        else if(result == 3){
            if((oCount - xCount <= 1 && oCount - xCount >= 0) || (oCount == 0 && xCount == 0)) answer = 1;
            else answer = 0;
        } 

        return answer;
    }
    
    // 0 -> 둘다이김
    // 1 -> O가 이김
    // 2 -> X가 이김
    // 3 -> 승부가 안남
    public int whoWins(String[][] arr){
        boolean oWin = false;
        boolean xWin = false;
        
        // 각 열 체크
        for(int i = 0; i < arr.length; i++){
            String current = arr[i][0];
            int sameCount = 0;
            for(int j = 1; j < arr[0].length; j++){
                if(current.equals(arr[i][j])){
                    sameCount++;
                    current = arr[i][j];
                }else break;
            }
            if(sameCount == 2){
                if(current.equals("O")) oWin = true;
                else if(current.equals("X")) xWin = true;
            }
            System.out.println(oWin);
        }
        
        // 각 행 체크
        for(int i = 0; i < arr.length; i++){
            String current = arr[0][i];
            int sameCount = 0;
            for(int j = 1; j < arr[0].length; j++){
                if(current.equals(arr[j][i])){
                    sameCount++;
                    current = arr[j][i];
                }
            }
            if(sameCount == 2){
                if(current.equals("O")) oWin = true;
                else if(current.equals("X")) xWin = true;
            }
            System.out.println(oWin);
        }
        // 대각선 체크
        String current1 = arr[0][0];
        if(current1.equals(arr[1][1]) && current1.equals(arr[2][2])){
            if(current1.equals("O")) oWin = true;
            else if(current1.equals("X")) xWin = true;
        } 
        System.out.println(oWin);
        
        String current2 = arr[0][2];
        if(current2.equals(arr[1][1]) && current2.equals(arr[2][0])){
            if(current2.equals("O")) oWin = true;
            else if(current2.equals("X")) xWin = true;
        }
        System.out.println(oWin);
        
        if(oWin && xWin) return 0;
        else if(oWin) return 1;
        else if(xWin) return 2;
        return 3;
    }
}