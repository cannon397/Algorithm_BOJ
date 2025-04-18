import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        char[][][] visited = new char[11][11][4];
        int[] currentPosition = {5, 5};
        for(int i = 0; i < dirs.length(); i++){
            char c = dirs.charAt(i);
            int[] nextXY = nextDirection(c);
            int cX = currentPosition[0];
            int cY = currentPosition[1];
            int nX = cX + nextXY[0];
            int nY = cY + nextXY[1];
            if(nX > 10 || nY > 10 || nX < 0 || nY < 0){
                continue;
            }
            for(int j = 0; j < 4; j++){
                if(visited[cX][cY][j] == '\0' ){
                    visited[cX][cY][j] = c;
                    answer++;
                    System.out.printf("cX: %d, cY %d\n", cX, cY);
                    break;
                }
                if(visited[cX][cY][j] == c){
                    break;
                }
            }
            char crossC = getCrossDirection(c);
            for (int j = 0; j < 4; j++) {
                if (visited[nX][nY][j] == '\0') {
                    visited[nX][nY][j] = crossC;
                    break;
                }
                if (visited[nX][nY][j] == crossC) {
                    break;
                }
            }
            currentPosition[0] = nX;
            currentPosition[1] = nY;
            
        }
        return answer;
    }
    public char getCrossDirection(char direction){
        char CrossDirection = '\0';
        switch(direction){
                case 'U':
                CrossDirection = 'D';
                break;
                case 'D':
                CrossDirection = 'U';
                break;
                case 'L':
                CrossDirection = 'R';
                break;
                case 'R':
                CrossDirection = 'L';
                break;
        }
        return CrossDirection;
    }
    public int[] nextDirection(char direction){
        int[] nextXY = new int[2];
        switch(direction){
                case 'U':
                nextXY[0] = 0;
                nextXY[1] = 1;
                break;
                case 'D':
                nextXY[0] = 0;
                nextXY[1] = -1;
                break;
                case 'L':
                nextXY[0] = -1;
                nextXY[1] = 0;
                break;
                case 'R':
                nextXY[0] = 1;
                nextXY[1] = 0;
                break;
        }
        return nextXY;
    }
}