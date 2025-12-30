import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;


class Solution{
	public static void main(String args[]) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
        int[] numArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = numArr[0] - numArr[1];
        String winner = "";
        if(result < 0 && result > -2) winner = "B";
        else winner = "A";
        System.out.println(winner);
	}
    
}