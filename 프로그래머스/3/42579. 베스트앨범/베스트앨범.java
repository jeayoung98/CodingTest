import java.util.*;

class Solution {
    
    public class genreCount{
        String genre;
        int count;
        public genreCount(String genre, int count){
            this.genre = genre;
            this.count = count;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        // 장르별로 가장 많이 재생된 노래 2개씩
        // 1. 속한 노래가 많이 재생된 장르 먼저
        // 2. 장르 내 많이 재생된 노래 먼저
        // 3. 재생횟수가 같으면 고유번호가 낮은 노래
        
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i],map.getOrDefault(genres[i],0) + plays[i]);
        }
        List<genreCount> list = new ArrayList<>();
        for(String s : map.keySet()){
            list.add(new genreCount(s,map.get(s)));
        }
        list.sort((a,b) -> b.count - a.count);
        
        List<Integer> resultList = new ArrayList<>();
        for(genreCount gc : list){
            int[] arr = playCount(genres,plays,gc.genre);
            for(int j = 0 ; j < arr.length; j++){
                resultList.add(arr[j]);
            }
        }
        int[] answer = new int[resultList.size()];
        
        for(int i = 0; i < resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        return answer;
    }
    
    public int[] playCount(String[] genres, int[] plays, String genre){
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < genres.length; i++){
            if(genres[i].equals(genre)){
                list.add(new int[] {i,plays[i]});
            }
        }
        
        list.sort((a,b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return b[1] - a[1];
            });
        
        return list.size() == 1 ? new int[] {list.get(0)[0]} : new int[] {list.get(0)[0], list.get(1)[0]};
    }
}