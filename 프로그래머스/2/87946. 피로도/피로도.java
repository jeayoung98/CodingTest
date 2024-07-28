import java.util.*;
import java.util.stream.*;

class Solution {
    public int ans = 0;
    public int solution(int k, int[][] dungeons) {
        dfs(k,dungeons,0);
        return ans;
    }
    public void dfs(int k,int[][]d,int a){
        ans = Math.max(a,ans);
        for(int i =0;i<d.length;i++) if(k>=d[i][0]) dfs(k - d[i][1], Stream.concat(Arrays.stream(Arrays.copyOfRange(d, 0, i)), Arrays.stream(Arrays.copyOfRange(d, i + 1, d.length))).toArray(int[][]::new), a + 1);
    }
}