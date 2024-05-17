class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10; // * 위치 12
        int right = 12; // # 위치 12
        
        for (int number : numbers) {
            if (number == 0) number = 11; // 0 위치 11
            
            if (number % 3 == 1) { // 1, 4, 7
                answer.append("L");
                left = number;
            } else if (number % 3 == 0) { // 3, 6, 9
                answer.append("R");
                right = number;
            } else { // 2, 5, 8, 0
                answer.append(middle(number, left, right, hand));
                if (answer.charAt(answer.length() - 1) == 'L') {
                    left = number;
                } else {
                    right = number;
                }
            }
        }
        
        return answer.toString();
    }

    public String middle(int num, int left, int right, String hand) {
        int leftDist = getDistance(left, num);
        int rightDist = getDistance(right, num);

        if (leftDist < rightDist) {
            return "L";
        } else if (rightDist < leftDist) {
            return "R";
        } else {
            return hand.equals("right") ? "R" : "L";
        }
    }
    
    // 맨해튼 거리공식, 좌표평면 대입 
    public int getDistance(int a, int b) {
        int aRow = (a - 1) / 3;
        int aCol = (a - 1) % 3;
        int bRow = (b - 1) / 3;
        int bCol = (b - 1) % 3;
        return Math.abs(aRow - bRow) + Math.abs(aCol - bCol);
    }
}
