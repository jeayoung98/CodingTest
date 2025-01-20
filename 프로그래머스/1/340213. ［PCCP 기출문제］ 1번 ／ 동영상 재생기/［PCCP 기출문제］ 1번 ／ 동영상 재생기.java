import java.util.*;

class Solution {
    int length, current, start, end;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        length = convert(video_len);
        current = convert(pos);
        start = convert(op_start);
        end = convert(op_end);
        for(String command : commands){
            if(command.equals("prev")) prev();
            else next();
        }
        return toString(current / 60) + ":" + toString(current % 60);
    }
    
    public void prev(){
        skip();
        if(current - 10 >= 0) current -= 10;
        else current = 0;
        skip();
    }
    
    public void next(){
        skip();
        if(current + 10 <= length) current += 10;
        else current = length;
        skip();
        
    }
    
    public int convert(String time){
        int[] arr = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return arr[0] * 60 + arr[1];
    }
    
    public void skip(){
        if(current >= start && current <= end) current = end;
    }
    
    public String toString(int x){
        if(x / 10 < 1) return "0" + x;
        return x + "";
    }
    
    
}