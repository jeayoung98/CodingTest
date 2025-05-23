class Solution {
    int plusMax = 0;
    int salesMax = 0;
    int[] discountArr = {10, 20, 30, 40};
    int[][] users;
    int[] emoticons;
    int length;
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        this.length = emoticons.length;
        
        dfs(0, new int[length]);
        
        return new int[]{plusMax, salesMax};
    }
    
    public void dfs(int depth, int[] arr) {
        if (depth == length) {
            check(arr);
            return;
        }
        for (int discount : discountArr) {
            arr[depth] = discount;
            dfs(depth + 1, arr);
        }
    }
    
    public void check(int[] arr) {
        int plus = 0;
        int sales = 0;
        
        for (int[] user : users) {
            int rate = user[0], max = user[1], sum = 0;
            for (int i = 0; i < length; i++) {
                if (arr[i] >= rate) {
                    sum += emoticons[i] * (100 - arr[i]) / 100;
                }
            }
            if (sum >= max) {
                plus++;
            } else {
                sales += sum;
            }
        }
        
        if (plus > plusMax || (plus == plusMax && sales > salesMax)) {
            plusMax = plus;
            salesMax = sales;
        }
    }
}
