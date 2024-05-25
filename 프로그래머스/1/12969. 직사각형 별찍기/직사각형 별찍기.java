import java.io.*;
import java.util.stream.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] i = br.readLine().split(" ");
        String stars = IntStream.range(0,Integer.parseInt(i[0]))
                                .mapToObj(num -> "*")
                                .collect(Collectors.joining());
        IntStream.range(0,Integer.parseInt(i[1]))
                .forEach(m -> System.out.println(stars));
        
    }
}