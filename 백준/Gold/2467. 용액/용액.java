import java.io.*;
import java.util.*;

public class Main {
    static int minSum = Integer.MAX_VALUE;
    static int[] minArr = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int positiveIndex = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                positiveIndex = i;
                break;
            }
        }

        // 다 음수
        if (positiveIndex == arr.length) {
            minArr[0] = arr[arr.length - 2];
            minArr[1] = arr[arr.length - 1];
        }
        // 다 양수
        else if (positiveIndex == 0) {
            minArr[0] = arr[0];
            minArr[1] = arr[1];
        }
        else {
            // 음수 + 음수
            if (positiveIndex > 1) {
                for (int i = 0; i < positiveIndex - 1; i++) {
                    int target = -arr[i];
                    int index = binarySearch(arr, i + 1, positiveIndex - 1, target);
                    
                    if (index <= positiveIndex - 1 && index > i) {
                        updateMin(Math.abs(arr[i] + arr[index]), arr[i], arr[index]);
                    }

                    if (index - 1 >= i + 1 && index - 1 <= positiveIndex - 1) {
                        updateMin(Math.abs(arr[i] + arr[index - 1]), arr[i], arr[index - 1]);
                    }
                }
            }
            
            // 음수 + 양수
            for (int i = 0; i < positiveIndex; i++) {
                int target = -arr[i];
                int index = binarySearch(arr, positiveIndex, arr.length - 1, target);

                if (index < arr.length) {
                    updateMin(Math.abs(arr[i] + arr[index]), arr[i], arr[index]);
                }
                if (index - 1 >= positiveIndex) {
                    updateMin(Math.abs(arr[i] + arr[index - 1]), arr[i], arr[index - 1]);
                }
            }
            
            // 양수 + 양수
            if (arr.length - positiveIndex > 1) {
                for (int i = positiveIndex; i < arr.length - 1; i++) {
                    int target = -arr[i];
                    int index = binarySearch(arr, i + 1, arr.length - 1, target);

                    if (index < arr.length && index > i) {
                        updateMin(Math.abs(arr[i] + arr[index]), arr[i], arr[index]);
                    }
                    if (index - 1 >= i + 1) {
                        updateMin(Math.abs(arr[i] + arr[index - 1]), arr[i], arr[index - 1]);
                    }
                }
            }
        }
        
        if (minArr[0] > minArr[1]) {
            int temp = minArr[0];
            minArr[0] = minArr[1];
            minArr[1] = temp;
        }
        System.out.println(minArr[0] + " " + minArr[1]);
    }
    
    public static int binarySearch(int[] arr, int start, int end, int target) {
        int left = start;
        int right = end;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    private static void updateMin(int absSum, int v1, int v2) {
        if (absSum < minSum) {
            minSum = absSum;
            minArr[0] = v1;
            minArr[1] = v2;
        }
    }
}
