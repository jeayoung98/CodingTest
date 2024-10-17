class Solution {
    int[][][] directions = {
            {{-1, -1}, {0, -1}, {-1, 0}},
            {{-1, 0}, {-1, 1}, {0, 1}},
            {{0, -1}, {1, -1}, {1, 0}},
            {{1, 0}, {0, 1}, {1, 1}}
    };
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] boards = new String[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boards[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
        boolean changed;
        do {
            changed = false;
            for(int x = 0; x < m; x++){
                for(int y = 0; y < n; y++){
                    if (check(boards, x, y) > 0) {
                        changed = true;
                    }
                }
            }
            if (changed) {
                pushDown(boards);
            }
        } while (changed);

        return count(boards);
    }

    public int check(String[][] boards,int x, int y){
        int checkCount = 0;
        for(int i = 0; i < 4; i++){
            int count = 0;
            for(int j = 0; j < 3; j++){
                int nx = x + directions[i][j][0];
                int ny = y + directions[i][j][1];
                if(nx >= 0 && nx < boards.length && ny >= 0 && ny < boards[0].length && boards[nx][ny].equalsIgnoreCase(boards[x][y])){
                    count++;
                }else break;
            }
            if(count == 3){
                for(int k = 0; k < 3; k++){
                    int nx = x + directions[i][k][0];
                    int ny = y + directions[i][k][1];
                    String current = boards[nx][ny];
                    if(!current.isEmpty() &&current.charAt(0) < 96){
                        boards[nx][ny] = current.toLowerCase();
                        checkCount++;
                    }

                }
                if(!boards[x][y].isEmpty()&&boards[x][y].charAt(0) < 96){
                    boards[x][y] = boards[x][y].toLowerCase();
                    checkCount++;
                }
            }
        }
        return checkCount;
    }

    public void pushDown(String[][] boards) {
        for (int j = 0; j < boards[0].length; j++) {
            int empty = boards.length - 1;

            // 아래에서 위로
            for (int i = boards.length - 1; i >= 0; i--) {
                if (!boards[i][j].equals("") && boards[i][j].charAt(0) < 96) {
                    if (empty != i) {
                        boards[empty][j] = boards[i][j];
                    }
                    empty--;
                }
            }
            for (int k = empty; k >= 0; k--) {
                boards[k][j] = "";
            }
        }
    }

    public int count(String[][] boards){
        int result = 0;
        for(int i = 0; i < boards.length; i++){
            for(int j = 0; j < boards[0].length; j++){
                if(boards[i][j].equals("")){
                    result++;
                }
            }
        }
        return result;
    }
}