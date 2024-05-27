import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int[][] arr = new int[wallpaper.length][wallpaper[0].length()];
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[0].length(); j++){
                if(wallpaper[i].charAt(j) == '#') arr[i][j] = 1;
                else arr[i][j] = 0;
            }
        }
        int maxCol = 0;
        int minCol = Integer.MAX_VALUE;
        int maxRow = 0;
        int minRow = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length;j++){
                if(arr[i][j] == 1){
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                }
            }
        }
        
        return new int[] {minRow,minCol,maxRow + 1,maxCol + 1};
    }
}