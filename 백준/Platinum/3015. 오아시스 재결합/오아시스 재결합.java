import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    static class StackElement {
        int height;
        int count;

        StackElement(int height, int count){
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<StackElement> deque = new ArrayDeque<>();
        long count = 0;

        for(int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            
            while(!deque.isEmpty() && height > deque.peek().height){
                count += deque.peek().count;
                deque.pop();
            }

            if(!deque.isEmpty() && height == deque.peek().height){
                count += deque.peek().count;
                
                if(deque.size() >= 2){
                    count += 1;
                }
                
                deque.peek().count++;
            }
            else{
                if(!deque.isEmpty()){
                    count += 1;
                }
                
                deque.push(new StackElement(height, 1));
            }
        }
        System.out.println(count);
    }
}
