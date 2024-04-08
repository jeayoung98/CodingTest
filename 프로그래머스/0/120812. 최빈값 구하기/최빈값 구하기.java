import java.util.*;
class Solution {
    public static int solution(int[] array) {
        int answer = 0;
        int count1 = 0;
        int count2 = 0;
        int mostFrequent = 0;

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            count1 = 1;

            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count1++;
                }
            }

            if (count1 > count2) {
                count2 = count1;
                mostFrequent = array[i];
            } else if (count1 == count2) {
                mostFrequent = -1;
            }
        }

        return mostFrequent;
    }
}
        
        
        
    


        
        
        
    


        
        
        
    

        
        
        
    
