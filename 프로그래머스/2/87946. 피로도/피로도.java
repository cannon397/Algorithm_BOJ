import java.util.*;
class Solution {
    boolean[] visited;
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        int n = dungeons.length;
        visited = new boolean[n];
        answer = dfs(k, 0, dungeons, 0);
        return answer;
    }
    public int dfs(int k, int start, int[][] dungeons, int count){
        answer = Math.max(answer, count);
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0] && k - dungeons[i][1] >= 0){
                visited[i] = true;
                dfs(k - dungeons[i][1], i, dungeons, count + 1);
                visited[i] = false;
            }
        }
        return answer;
    }
}