import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            q.offer(s.charAt(i));
        }
        int index = 0;
        String temp = "";
        while(!q.isEmpty()){
            char c = q.poll();
            if(temp.contains(String.valueOf(c))){
                answer[index] = index - temp.lastIndexOf(c);
            }else{
                answer[index] = -1;            
            }
            temp += String.valueOf(c);
            index++;
        }
        return answer;
    }
}