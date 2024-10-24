import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int size = arr.length;
        int k = 2;

        while (k <= size){
            for (int i = 0; i < size; i += k) {
                for (int j = 0; j < size; j += k) {
                    if (i + k <= size && j + k <= size && isSame(arr, i, j, k)) {
                        fill(arr, i, j, k, arr[i][j] > 0 ? k : -k);
                    }
                }
            }
            k *= 2;
        };
        
        // for(int i = 0; i < arr.length; i++){
        //     for(int j = 0; j < arr[0].length; j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // 카운팅 결과를 반환하는 배열
        double[] result = {0, 0};
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] > 0) {
                    result[1] += 1 / Math.pow(arr[i][j],2);
                } else if (arr[i][j] < 0) {
                    result[0] += 1 / Math.pow(arr[i][j],2);
                    // System.out.println(Math.abs(arr[i][j]));
                    // System.out.println(Math.pow(arr[i][j],2));
                }
                else result[0]++;
                // System.out.println(Arrays.toString(result));
            }
        }
        answer[0] = (int)result[0];
        answer[1] = (int)result[1];

        return answer;
    }

    // 같은 값인지 확인
    public boolean isSame(int[][] arr, int x, int y, int k) {
        int value = arr[x][y];
        int count = 0;
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                if(arr[x][y] > 0 && arr[i][j] > 0) count++;
                else if(arr[x][y] <= 0 && arr[i][j] <= 0) count++;
                
            }
        }
        return count == Math.pow(k,2) ? true:false;
    }

    public void fill(int[][] arr, int x, int y, int k, int value) {
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                arr[i][j] = value;
            }
        }
    }
}
