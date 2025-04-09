import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] wall = new boolean[n + 1];
        Arrays.fill(wall,true);
        for(int s : section){
            wall[s] = false;
        }
        for(int i = 1; i <= n; i++){
            if(!wall[i]){
                i += m - 1;
                answer++;
            }
        }

        return answer;
    }
}