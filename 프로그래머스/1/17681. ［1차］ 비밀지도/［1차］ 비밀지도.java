class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] wall = new String[n][n];
        
        for(int i = 0; i < n; i++){ // arr1 2진수 변환후 wall에 넣기
            for(int j = 0; j < n; j++){
                wall[i][j] = binary(arr1[i],n).charAt(j)+"";
            }
        }
        
        for(int i = 0; i < n; i++){ // wall과 arr2 2진수 변환한거 1개라도 1이면 1
            for(int j = 0; j < n; j++){
                if(wall[i][j].equals("1") || binary(arr2[i],n).charAt(j) == '1') wall[i][j] = "1";
            }
        }
        
        for(int i = 0; i < n; i++){ // wall의 1을 #으로 0을 공백으로
            String str = "";
            for(int j = 0; j < n; j++){
                
;                if(wall[i][j].equals("1")) str += "#";
                else str += " ";
                
            }answer[i] = str;
        }
        return answer;
    }
    
    public String binary(int num,int n){
        String answer = "";
        answer += Integer.toBinaryString(num);
        while(answer.length()<n) answer = "0" + answer;
        return answer;
    }
}