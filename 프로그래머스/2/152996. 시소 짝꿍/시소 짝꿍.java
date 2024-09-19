import java.util.*;
import java.util.stream.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        double[] rate = new double[] {1,2,1.5,0.75};
        Map<Double,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < weights.length; i++){
            for(int j = 0; j < rate.length; j++){
                double num = (weights[i] * rate[j]);
                List<Integer> list = map.getOrDefault(num,new ArrayList<>());
                list.add(weights[i]);
                map.put(num,list);
            }
        }
        List<Double> list = Arrays.stream(weights)
                                   .mapToDouble(x -> x)
                                   .boxed()
                                   .collect(Collectors.toList());
        answer += map.entrySet().stream()
                         .filter(entry -> list.contains(entry.getKey()))
                         .mapToLong(entry -> countPairs(entry.getKey(),entry.getValue()))
                         .sum();        
        return answer;
    }
    
    public long countPairs(double num,List<Integer> list){
        long result = 0L;
        long count = list.stream().filter(i -> (double)i == num).count();
        result += count * (count - 1) / 2;
        result += ((long)list.size() - count) * count;
        return result;
    }
}