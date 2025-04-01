import java.util.*;

class Solution {
    class Task {
        String name;
        int start;
        int playtime;
        public Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    
    public String[] solution(String[][] plans) {
        int n = plans.length;
        List<Task> list = new ArrayList<>();
        for (String[] plan : plans) {
            list.add(new Task(plan[0], convertToMin(plan[1]), Integer.parseInt(plan[2])));
        }
        Collections.sort(list, (a, b) -> a.start - b.start);
        
        Stack<Task> stack = new Stack<>();
        List<String> answer = new ArrayList<>();
        int currentTime = list.get(0).start;
        
        for (int i = 0; i < n - 1; i++) {
            Task current = list.get(i);
            int nextStart = list.get(i + 1).start;
            int endTime = currentTime + current.playtime;
            
            if (endTime <= nextStart) {
                answer.add(current.name);
                int extra = nextStart - endTime;
                currentTime = endTime;
                
                while (!stack.isEmpty() && extra > 0) {
                    Task paused = stack.pop();
                    if (paused.playtime <= extra) {
                        extra -= paused.playtime;
                        currentTime += paused.playtime;
                        answer.add(paused.name);
                    } else {
                        paused.playtime -= extra;
                        currentTime += extra;
                        extra = 0;
                        stack.push(paused);
                    }
                }
                currentTime = nextStart;
            } else {
                int remaining = current.playtime - (nextStart - currentTime);
                stack.push(new Task(current.name, nextStart, remaining));
                currentTime = nextStart;
            }
        }
        
        Task last = list.get(n - 1);
        currentTime = Math.max(currentTime, last.start);
        currentTime += last.playtime;
        answer.add(last.name);
        
        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }
        
        return answer.toArray(new String[0]);
    }
    
    public int convertToMin(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
