import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(x);
        visited.add(x);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int current = q.poll();
                if(current == y) return answer;
                int[] nexts = {current * 2, current * 3, current + n};
                for(int next : nexts){
                    if(current <= y && !visited.contains(next)){
                        q.add(next);
                        visited.add(next);
                    }
                }
            }
            answer++;
        }
        return -1;
    }
}