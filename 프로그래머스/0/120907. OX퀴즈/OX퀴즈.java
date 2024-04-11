class Solution {
    public String[] solution(String[] quiz) {

        String[] answer = new String[quiz.length];
        
        for(int i = 0 ; i < quiz.length; i++) {
            String[] numArr = quiz[i].split(" ");
            int num1 = Integer.parseInt(numArr[0]);
            int num2 = Integer.parseInt(numArr[2]);
            int result = Integer.parseInt(numArr[4]);
        
            String operator = numArr[1];

            if (operator.equals("+")) {
                answer[i] = (num1 + num2 == result) ? "O" : "X";
            } else {
                answer[i] = (num1 - num2 == result) ? "O" : "X";
            }
        }
        return answer;
    }
}