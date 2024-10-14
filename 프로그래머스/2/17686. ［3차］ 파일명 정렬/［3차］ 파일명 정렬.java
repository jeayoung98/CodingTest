import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        List<String[]> list = new ArrayList<>();
        
        for(int i = 0; i < files.length; i++){
            String str = files[i];
            int j = 0;
            String[] arr = new String[3];
            arr[0] = head(str, j);
            j += arr[0].length(); 
            arr[1] = num(str, j);
            j += arr[1].length(); 
            arr[2] = tail(str, j); 
            list.add(arr);
        }
        List<String> sortedList = list.stream()
                            .sorted((a, b) -> {
                                int result = a[0].toUpperCase().compareTo(b[0].toUpperCase());
                                if (result != 0) {
                                    return result;
                                }
                                return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
                            }).map(arr -> String.join("", arr)).collect(Collectors.toList());
        return sortedList.toArray(new String[0]);
    }
    
    public String head(String str, int j) {
        StringBuilder s = new StringBuilder();
        while(j < str.length() && !Character.isDigit(str.charAt(j))){
            s.append(str.charAt(j));
            j++;
        }
        return s.toString();
    }
    
    public String num(String str, int j) {
        StringBuilder s = new StringBuilder();
        while(j < str.length() && Character.isDigit(str.charAt(j))){
            s.append(str.charAt(j));
            j++;
        }
        return s.toString();
    }
    
    public String tail(String str, int j) {
        StringBuilder s = new StringBuilder();
        while(j < str.length()){
            s.append(str.charAt(j));
            j++;
        }
        return s.toString();
    }
}
