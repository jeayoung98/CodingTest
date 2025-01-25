import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        return bfs(begin,target,words);
    }

    public int bfs(String begin, String target,String[] words){
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(begin, 0));

        Set<String> visited = new HashSet<>();
        visited.add(begin);

        while(!queue.isEmpty()){
            WordNode current = queue.poll();
            String currentWord = current.word;
            int currentLevel = current.level;

            if(currentWord.equals(target)){
                return currentLevel;
            }

            for(String word : words){
                if(!visited.contains(word) && compare(currentWord, word)){
                    visited.add(word);
                    queue.add(new WordNode(word, currentLevel + 1));
                }
            }
        }
        return 0;
    }
    private boolean compare(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
                if(count > 1){
                    return false;
                }
            }
        }
        return count == 1;
    }

    public class WordNode {
        String word;
        int level;

        WordNode(String word, int level){
            this.word = word;
            this.level = level;
        }
    }
}
