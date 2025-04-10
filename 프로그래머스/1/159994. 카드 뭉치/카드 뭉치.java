import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> card1q = new LinkedList<>();
        Queue<String> card2q = new LinkedList<>();
        for(String card : cards1){
            card1q.offer(card);
        }
        for(String card : cards2){
            card2q.offer(card);
        }
        for(String s : goal){
            if(!card1q.isEmpty() && card1q.peek().equals(s)){
                card1q.poll();
                continue;
            }
            if(!card2q.isEmpty() && card2q.peek().equals(s)){
                card2q.poll();
                continue;
            }
            
            System.out.println(s);
            answer = "No";
            break;
        }
        return answer;
    }
}