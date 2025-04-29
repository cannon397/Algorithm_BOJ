import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < players.length; i++){
            while(!q.isEmpty() && q.peek() + k == i){
                q.poll();
            }
            int n = q.size() + 1;
            while(players[i] >= m * n){
                q.add(i);
                answer++;
                System.out.println("증설 시각:" + i);
                n = q.size() + 1;
            }
        }
        return answer;
    }
}
