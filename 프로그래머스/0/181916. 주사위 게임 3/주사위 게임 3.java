import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer,Integer> map = countDiceNum(a,b,c,d);
        if(map.size() == 1) {
            for(int i : map.keySet()){
                answer += 1111 * i;
            }
        }else if(map.size() == 2){
            int sum = 0;
            for(int i : map.keySet()){
                if(map.get(i) == 3){
                    sum += 10*i;
                    
                }
                else if(map.get(i) == 1){
                    sum += i;
                }
                else if (map.get(i) == 2){
                    List<Integer> list = new ArrayList<>();
                    for(int j : map.keySet()){
                        list.add(j);
                    }
                    int num1 = list.get(0);
                    int num2 = list.get(1);
                    answer = Math.abs(num1-num2) * (num1 + num2);
                    if(list.size() == 2) break;
                }
            }if(sum != 0) answer = (int)Math.pow(sum,2);
        }
        else if (map.size() == 3){
            int sum = 1;
            for(int i : map.keySet()){
                if(map.get(i) == 1){
                    sum *= i;
                }
            } answer = sum;
        }else if(map.size() == 4){
            int min = 7;
            for(int i : map.keySet()){
                min = Math.min(min,i);
            }
            answer += min;
        }
        
        return answer;
    }
    
    public Map<Integer,Integer> countDiceNum(int a, int b, int c, int d){
        Map<Integer,Integer> map = new HashMap<>();
        int[] dice = {a,b,c,d};
        for(int i : dice){
            if(map.containsKey(i)){
                map.replace(i,map.get(i)+1);
            }else map.put(i,1);
        }
        return map;
    }
}