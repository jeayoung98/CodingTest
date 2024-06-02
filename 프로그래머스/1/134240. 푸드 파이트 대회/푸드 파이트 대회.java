import java.util.stream.*;

class Solution {
    public String solution(int[] food) {
        String half = IntStream.range(1, food.length)
                .mapToObj(i -> String.valueOf(i).repeat(food[i] / 2))
                .collect(Collectors.joining());
        
        return half + "0" + new StringBuilder(half).reverse().toString();
    }
}
