import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            int x = s.length();
            s = s.replace("0", "");
            int c = s.length();
            answer[1] += x - c;
            s = Integer.toBinaryString(c);
            answer[0]++;
        }
        return answer;
    }
}