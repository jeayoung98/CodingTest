import java.util.stream.*;
class Solution {
    public String solution(String phone_number) {
        return  IntStream.range(0,phone_number.length() - 4)
                        .mapToObj(i -> "*")
                        .collect(Collectors.joining()) + phone_number.substring(phone_number.length() - 4);
    }
}