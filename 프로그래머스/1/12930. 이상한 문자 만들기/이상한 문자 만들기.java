class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder answer = new StringBuilder();
        String[] strArr = s.split("");
        int index = 0;
        for(int i = 0; i < strArr.length; i++){
            if(strArr[i].equals(" ")) index = 0;
            if(index % 2 == 0){
                strArr[i] = strArr[i].toUpperCase();
            }
            if(!strArr[i].equals(" ")) index++;
            answer.append(strArr[i]);
        }
        return answer.toString();
    }
}