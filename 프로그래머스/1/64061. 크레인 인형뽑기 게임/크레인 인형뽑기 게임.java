import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < moves.length; i++){
            for(int j = 0; j < board.length; j++){
                int doll = board[j][moves[i] - 1];
                if(doll == 0) continue;
                if(!stack.isEmpty() && stack.peek() == doll){
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(doll);
                }
                board[j][moves[i] - 1] = 0;
                break;
            }
        }
        return answer;
    }
}