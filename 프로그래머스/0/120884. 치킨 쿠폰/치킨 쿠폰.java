class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while (chicken >= 10){
            int service = chicken / 10;
            int coupon = chicken %  10;

            chicken = service + coupon;

            answer += service;

        }


        return answer;
    }
}