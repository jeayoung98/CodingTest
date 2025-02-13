class Solution {
    int answer = 0;
    int floor;
    public int solution(int storey) {
        floor = storey; 
        do {
            // System.out.println(floor);
            int value = floor % 10;
            floor /= 10;
            move(value);
        } while(floor != 0);
        return answer;
    }
    
    public boolean isRoundedUp(int value) {
        if(floor % 10 >= 5  && value == 5) return true;
        return value > 5;
    }

    public void move(int value) {
        if(isRoundedUp(value)) {
            answer += (10 - value);
            floor += 1;
        } else {
            answer += value;
        }
    }
}
