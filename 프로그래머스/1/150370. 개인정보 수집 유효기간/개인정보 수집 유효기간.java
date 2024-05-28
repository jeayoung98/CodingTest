import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String,Integer> map = new HashMap<>();
        String[] todayArr = today.split("\\.");
        
        for(String str : terms){
            String[] strArr = new String[2];
            strArr = str.split(" ");
            map.put(strArr[0],Integer.parseInt(strArr[1]));
        }
        int[] intArr = new int[3];
        for(int i=0;i<privacies.length;i++){
            String[] strArr2 = new String[2]; //유형 strArr2[1]
            String[] yearArr ; // 개인정보날짜 
            strArr2 = privacies[i].split(" ");
            yearArr = strArr2[0].split("\\.");
            int num = map.get(strArr2[1]); // 유효기간 월 
            for(int j=0;j<yearArr.length;j++){
                intArr[j] = Integer.parseInt(yearArr[j]);
            }

            intArr[0]+= (intArr[1]+num)%12==0?(intArr[1]+num)/12-1:(intArr[1]+num)/12;
            intArr[1]= (intArr[1]+num)%12==0?(intArr[1]+num)%12+12:(intArr[1]+num)%12;
            
            if(Integer.parseInt(todayArr[0])>intArr[0]){
                answer.add(i+1);
            }else if(Integer.parseInt(todayArr[0]) == intArr[0]){
               if(Integer.parseInt(todayArr[1])>intArr[1]){
                    answer.add(i+1);
                }else if(Integer.parseInt(todayArr[1]) == intArr[1]){
                     if(Integer.parseInt(todayArr[2]) >= intArr[2]){
                        answer.add(i+1);
                    }
                } 
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}