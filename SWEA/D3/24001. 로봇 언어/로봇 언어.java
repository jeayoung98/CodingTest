import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            int index, max1, max2;

            index = 0; 
            max1 = 0;
            for (char c : s.toCharArray()) {
                if (c == 'L')      index--;
                else  index++;
                max1 = Math.max(max1, Math.abs(index));
            }

            index = 0; 
            max2 = 0;
            for (char c : s.toCharArray()) {
                if (c == 'R')      index++;
                else  index--;
                max2 = Math.max(max2, Math.abs(index));
            }

            System.out.println(Math.max(max1, max2));
        }
        sc.close();
    }
}