class Solution {
    public int solution(int[][] board) {
        
        int[][] safe = new int[board.length+2][board.length+2];
        
        int area = board.length * board.length; // 전체 칸수
        
        for(int i = 0; i < safe.length;i++){ // safe배열 0으로 채우기
            for(int j = 0; j< safe.length;j++){
                safe[i][j] = 0;
            }
        }
        int answer = 0; // 안전구역
        int count = 0; // 지뢰 개수
        
        for(int i =0;i<board.length;i++){ // 모든 구역 지뢰 0
            for(int j =0; j<board.length;j++){
                if(board[i][j]==1){
                    count++;
                }
            }if(count == area) return 0; 
        }
        
        for(int i = 1 ; i < board.length+1; i++){ // 지뢰포함 근처 구역 safe배열 1
            for(int j = 1; j<board.length + 1;j++){
                if(board[i-1][j-1]==1){
                    safe[i][j] = 1;
                    safe[i][j-1] = 1;
                    safe[i][j+1] = 1;
                    safe[i+1][j] = 1;
                    safe[i+1][j+1] = 1;
                    safe[i+1][j-1] = 1;
                    safe[i-1][j] = 1;
                    safe[i-1][j+1] = 1;
                    safe[i-1][j-1] = 1;
                }
            }
        }
                    
        for(int i = 1; i < board.length+1;i++){
            for(int j = 1; j< board.length+1;j++){
                if(safe[i][j] == 1){
                    answer+=1;
                }
            }
        }
        return area - answer;
    }
}




