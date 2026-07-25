import java.util.*;

class Solution {
    int[] info;
    List<List<Integer>> tree;
    int max = 0;

    public int solution(int[] info, int[][] edges) {
        this.info = info;

        tree = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);

        backtrack(0, 0, list);

        return max;
    }

    public void backtrack(int sheep, int wolf, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int next = list.get(i);

            int nextSheep = sheep;
            int nextWolf = wolf;

            if (info[next] == 0) {
                nextSheep++;
            } else {
                nextWolf++;
            }

            // 늑대가 양보다 많거나 같음
            if (nextSheep <= nextWolf) continue;

            max = Math.max(max, nextSheep);
            List<Integer> nextList = new ArrayList<>(list);
            nextList.remove(i);

            for (int child : tree.get(next)) {
                nextList.add(child);
            }

            backtrack(nextSheep, nextWolf, nextList);
        }
    }
}