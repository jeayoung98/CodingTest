import java.util.*;

class Solution {
    public class Music{
        int start;
        int length;
        String title;
        String sound;
        public Music(int start, int length, String title, String sound){
            this.start = start;
            this.length = length;
            this.title = title;
            this.sound = sound;
        }
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        List<Music> list = new ArrayList<>();
        m = convertSound(m);
        // System.out.println(m);
        for(String s : musicinfos){
            String[] arr = s.split(",");
            int length = convertMin(arr[1]) - convertMin(arr[0]);
            String sound = convertSound(arr[3]) + convertSound(arr[3]);
            // System.out.println(sound);
            list.add(new Music(convertMin(arr[0]), length, arr[2], realSound(sound, length)));
        }
        Music result = new Music(0,0,"","");
        for(Music music : list){
            String current = music.sound;
            if(current.contains(m) || m.contains(current)){
                if(result.length < music.length){
                    result = music;
                }
                else if(result.length == music.length){
                    if(result.start > music.start) result = music;
                }
            }
        }
        if(result.length != 0) answer = result.title;
        return answer;
    }
    
    public int convertMin(String time){
        int[] arr = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return arr[0] * 60 + arr[1];
    }
    
    public String convertSound(String sound){
        String[] arr = sound.split("");
        String result = "";
        for(int i = 0; i < arr.length; i++){
            if(i != arr.length - 1 && arr[i + 1].equals("#")){
                arr[i] = arr[i].toLowerCase();
            }
            if(!arr[i].equals("#")) result += arr[i];
        }
        // System.out.println(result);
        return result;
    }
    
    public String realSound(String sound, int time){
        String[] arr = sound.split("");
        String result = "";
        for(int i = 0; i < time; i++){
            result += arr[i % sound.length()];
        }
        return result;
    }
}