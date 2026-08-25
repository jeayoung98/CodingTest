import java.util.*;

class Solution {
    String[] userId, bannedId;
    Set<Integer> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        this.userId = user_id;
        this.bannedId = banned_id;

        dfs(0, 0);

        return result.size();
    }

    void dfs(int bIdx, int select) {
        if (bIdx == bannedId.length) {
            result.add(select);
            return;
        }

        for (int i = 0; i < userId.length; i++) {
            if ((select & (1 << i)) != 0) {
                continue;
            }

            if (isMatch(userId[i], bannedId[bIdx])) {
                dfs(bIdx + 1, select | (1 << i));
            }
        }
    }

    boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') {
                continue;
            }
            if (user.charAt(i) != banned.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}