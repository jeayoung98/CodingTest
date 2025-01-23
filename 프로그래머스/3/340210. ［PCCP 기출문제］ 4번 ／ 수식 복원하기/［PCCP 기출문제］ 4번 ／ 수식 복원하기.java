import java.util.*;

class Solution {
    int min = 2;
    int max = 9;
    public String[] solution(String[] expressions) {
        List<Integer> possibleBases = new ArrayList<>();

        List<Integer> numList = new ArrayList<>();
        for (String s : expressions) {
            String[] parts = s.split(" ");
            for(int i = 0; i<=4; i += 2){
                if(!parts[i].equals("X")){
                    if(Integer.parseInt(parts[i]) >= 10){
                        String[] strArr = parts[i].split("");
                        for(int j = 0; j < strArr.length; j++){
                            numList.add(Integer.parseInt(strArr[j]));
                        }
                    }else{
                        numList.add(Integer.parseInt(parts[i]));
                    }
                } 
                
            }
        }
        int listMax = numList.stream().mapToInt(Integer::intValue).max().orElse(9);
        
        if(listMax >= 2) min = listMax + 1;
        
        for (int base = min; base <= max; base++) {
            if (isValidBase(expressions, base)) {
                possibleBases.add(base);
            }
        }

        List<String> resultList = new ArrayList<>();

        for (String s : expressions) {
            String[] arr = s.split(" ");
            String A = arr[0];
            String operator = arr[1];
            String B = arr[2];
            String C = arr[4];

            if (C.equals("X")) {
                Set<String> possibleResults = new HashSet<>();

                for (int base : possibleBases) {
                    try {
                        int numA = Integer.parseInt(A, base);
                        int numB = Integer.parseInt(B, base);

                        int computed;
                        if (operator.equals("+")) {
                            computed = numA + numB;
                        } else {
                            computed = numA - numB;
                            if (computed < 0) {
                                continue;
                            }
                        }

                        String computedStr = Integer.toString(computed, base);
                        possibleResults.add(computedStr);
                    } catch (NumberFormatException e) {
                        continue;
                    }
                }

                if (possibleResults.size() == 1) {
                    String filledResult = possibleResults.iterator().next();
                    resultList.add(A + " " + operator + " " + B + " = " + filledResult);
                } else {
                    resultList.add(A + " " + operator + " " + B + " = ?");
                }
            }
        }

        return resultList.toArray(new String[0]);
    }

    private boolean isValidBase(String[] expressions, int base) {
        for (String expr : expressions) {
            String[] parts = expr.split(" ");
            String A = parts[0];
            String operator = parts[1];
            String B = parts[2];
            String C = parts[4];

            if (!C.equals("X")) {
                try {
                    int numA = Integer.parseInt(A, base);
                    int numB = Integer.parseInt(B, base);
                    int numC = Integer.parseInt(C, base);

                    int computed;
                    if (operator.equals("+")) {
                        computed = numA + numB;
                    } else {
                        computed = numA - numB;
                    }

                    if (computed != numC) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return true;
    }
}
