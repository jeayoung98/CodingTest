import java.util.*;
import java.util.stream.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length;i++){
            if(numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
            else{
                char[] c = Long.toBinaryString(numbers[i]).toCharArray();
                List<Character> list = IntStream.range(0, c.length)
                                        .mapToObj(a -> c[a])  
                                        .collect(Collectors.toList());
                if(list.size() == Long.bitCount(numbers[i])){
                    answer[i] = nextNum(list.size()+1);
                    System.out.println(list);
                }else{
                    int lastIndex = list.lastIndexOf('0');
                    list.set(lastIndex, '1');
                    int nextIndex = list.subList(lastIndex + 1, list.size()).indexOf('1') + lastIndex + 1;
                    list.set(nextIndex, '0');
                    answer[i] = Long.parseLong(list.stream()
                                            .map(String::valueOf)
                                            .collect(Collectors.joining()), 2);
                }
            }
        }
        return answer;
    }
    public long nextNum(int size){
        List<Character> list = new ArrayList<>();
        list.add('1');
        list.add('0');
        while(list.size() < size){
            list.add('1');
        }
        long result = Long.parseLong(list.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining()), 2);
        return result;
    }   
}
    
    

