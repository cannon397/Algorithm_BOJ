import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = -1;
        int[] dX = {0, 1, 0, -1};
        int[] dY = {1, 0, -1, 0};
        int[] start = new int[4];
        int x = maps.length;
        int y = maps[0].length();
        boolean[][] visited = new boolean[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                char c = maps[i].charAt(j);
                if(c == 'S'){
                    start[0] = i;
                    start[1] = j;
                    start[2] = 0;
                    start[3] = 0;
                }else if(c == 'X'){
                    visited[i][j] = true;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int[] currentPos = q.remove();
            int cX = currentPos[0];
            int cY = currentPos[1];
            int seconds = currentPos[2];
            int L = currentPos[3];
            if(maps[cX].charAt(cY) == 'L') {
                visited = new boolean[x][y];
                while(!q.isEmpty()) q.remove();
                for(int i = 0; i < x; i++){
                    for(int j = 0; j < y; j++){
                        char c = maps[i].charAt(j);
                        if(c == 'X'){
                            visited[i][j] = true;
                        }
                    }
                }
                L = 1;
                visited[cX][cY] = true;
            }
            if(maps[cX].charAt(cY) == 'E' && L == 1) return seconds;
            for(int i = 0; i < 4; i++){
                int nX = cX + dX[i];
                int nY = cY + dY[i];
                if(x > nX && nX >= 0 && y > nY && nY >= 0 && !visited[nX][nY]){
                    visited[nX][nY] = true;
                    q.add(new int[]{nX, nY, seconds + 1, L});
                }
            }
        }
        
        return answer;
    }
}