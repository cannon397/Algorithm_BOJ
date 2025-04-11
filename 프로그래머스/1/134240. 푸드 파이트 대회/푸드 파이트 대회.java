import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        String player1 = "";
        String player2 = "";
        for(int i = 1; i < food.length; i++){
            int mok = food[i] / 2;
            for(int j = 0; j < mok; j++){
                player1 += i;
                player2 = i + player2;
            }
        }
        answer = player1 + "0" + player2;
        return answer;
    }
}