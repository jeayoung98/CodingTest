import java.util.*;

class Solution {
    // mbti 유형
    String[][] mbtiArr = {{"R","T"},{"C","F"},{"J","M"},{"A","N"}};
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int idx = 0 ;
        int[] mbtiScoreArr = new int[4];
        for(String mbti : survey){
            // 점수 계산
            for(int i = 0; i < mbtiArr.length; i++){
                if(mbti.contains(mbtiArr[i][0])){
                    mbtiScoreArr[i] += mbtiScore(mbti,mbtiArr[i],choices[idx]);
                }
            }
            idx++;
        }
        answer += mbtiResult(mbtiScoreArr);
        return answer;
    }
    
    // 점수 계산 메서드
    public int mbtiScore(String mbti,String[] mbtiArr,int choice){
        int score = 0;
        if(mbti.startsWith(mbtiArr[0])){ // 앞에꺼로 시작하면
            score = 4 - choice;
        }else score = choice - 4;
        return score;
    }
    
    // mbti 결과 메서드
    public String mbtiResult(int[] mbtiScoreArr){
        StringBuilder mbti = new StringBuilder();
        for(int i = 0 ; i < mbtiScoreArr.length; i++){
            if(mbtiScoreArr[i] >= 0) mbti.append(mbtiArr[i][0]); // 양수거나 0이면 앞에꺼
            else mbti.append(mbtiArr[i][1]); // 음수면 뒤에꺼
        }
        return mbti.toString();
    }
}
