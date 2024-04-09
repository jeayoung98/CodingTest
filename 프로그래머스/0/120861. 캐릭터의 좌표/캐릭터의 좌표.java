class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        String[] dir = {"left","right","up","down"};
        int width = (board[0]-1)/2;
        int height =(board[1]-1)/2;
        int[] count = new int[4];
        
        for (String str : keyinput) {
            for (int i = 0; i < dir.length; i++) {
                if (str.equals(dir[i])) {
                    count[i] += 1;
                    answer[0] = count[1] - count[0];
                    answer[1] = count[2] - count[3];

                    if (answer[0] > width) {
                        answer[0] = width;
                        count[i] -=1;
                    } else if (answer[0] < -width) {
                        answer[0] = -width;
                        count[i] -=1;
                    }

                    else if (answer[1] > height) {
                        answer[1] = height;
                        count[i] -=1;
                    } else if (answer[1] < -height) {
                        answer[1] = -height;
                        count[i] -=1;
                    }
                }
            }
        }
        return answer;
    }
}