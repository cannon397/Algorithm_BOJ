import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> q = new LinkedList<>();
        for(char c : s.toCharArray()){
            q.offer(c);
        }
        while(!q.isEmpty()){
            char c = q.poll();
            int count = 1;
            while(!q.isEmpty()){
                if(q.peek() == c){
                    q.poll();
                    count++;
                    continue;
                }else{
                    count--;
                    q.poll();
                }
                if(count == 0){
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}