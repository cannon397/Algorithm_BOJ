import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int[] sp = new int[3];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                if(board[i].charAt(j) == 'R'){
                    sp[0] = i;
                    sp[1] = j;
                    break;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(sp);
        visited[sp[0]][sp[1]] = true;
        while(!q.isEmpty()){
            int[] cp = q.poll();
            int cx = cp[1];
            int cy = cp[0];
            int cm = cp[2];

            if (board[cy].charAt(cx) == 'G') {
                return cm;
            }

            
            for(int i = 0; i < 4; i++){
                int nx = cx;
                int ny = cy;
                
                while(true){
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    
                    if(ty >= board.length || 
                       ty < 0 || 
                       tx >= board[0].length() ||
                       tx < 0 || board[ty].charAt(tx) == 'D'){
                        break;
                    }
                    nx = tx;
                    ny = ty;
                }
                if(!visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, cm + 1});
                }
            }
        }
        return -1;
    }
}