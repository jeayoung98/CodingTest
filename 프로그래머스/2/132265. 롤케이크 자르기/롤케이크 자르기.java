import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int[] list1 = new int[topping.length];
        int[] list2 = new int[topping.length];
        for(int i=0;i<topping.length;i++){
            set1.add(topping[i]);
            list1[i]=set1.size();
        }
        for(int j=topping.length-1;j>=0;j--){
            set2.add(topping[j]);
            list2[j]=set2.size();
        }
        for(int i=1;i<list1.length;i++){
            if(list1[i-1]==list2[i]){
                answer++;
            }
        }
        return answer;
    }
}