class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dX = {0, 1, 0, -1};
        int[] dY = {1, 0, -1, 0};
        for(int i = 0; i < 4; i++){
            int nX = w + dX[i];
            int nY = h + dY[i];
            if(nX >= 0 && nX < board.length && nY >= 0 && nY < board[0].length){
                if(board[h][w].equals(board[nY][nX])) answer++;
            }
        }
        return answer;
    }
}