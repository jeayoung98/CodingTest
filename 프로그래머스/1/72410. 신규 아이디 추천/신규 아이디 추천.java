class Solution {
    public String solution(String new_id) {
        return under2(bothEndsDot(stringLength(bothEndsDot(removeDot(remove(lower(new_id)))))));
    }
    
    public String lower(String new_id) {
        return new_id.toLowerCase();
    }
    
    public String remove(String new_id) {
        return new_id.replaceAll("[^a-z0-9-_.]", "");
    }
    
    public String removeDot(String new_id) {
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        return new_id;
    }
    
    public String bothEndsDot(String new_id) {
        // 문자열이 빈 경우 처리
        if (new_id.isEmpty()) {
            return new_id;
        }
        
        // 첫 번째 문자가 '.'인 경우 제거
        if (new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        
        // 마지막 문자가 '.'인 경우 제거
        if (!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        return new_id;
    }
    
    public String stringLength(String new_id) {
        if (new_id.length() == 0) {
            return "a";
        } else if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        return new_id;
    }
    
    public String under2(String new_id) {
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        return new_id;
    }
}
