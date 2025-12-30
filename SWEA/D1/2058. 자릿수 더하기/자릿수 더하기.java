import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution{
	public static void main(String args[]) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		System.out.println(Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).sum());
        
		

	}
}