import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String,Integer> map = new HashMap<>();
        for(int i =0 ;i < name.length;i++){
            map.put(name[i],yearning[i]);
        }
        for(int i = 0 ; i < photo.length; i++){
            for(int j = 0 ; j < photo[i].length; j++){
                try{
                    answer[i] += map.get(photo[i][j]);
                }catch(Exception e){
                }
                
            }
        }
        return answer;
    }
}