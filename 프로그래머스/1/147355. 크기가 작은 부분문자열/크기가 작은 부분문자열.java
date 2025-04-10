import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for(int i = 0; i < t.length() - p.length() + 1; i++){
            StringBuilder s = new StringBuilder();
            for(int j = i; j < i + p.length(); j++){
                s.append(String.valueOf(t.charAt(j)));
            }
            if(Long.parseLong(s.toString()) <= Long.parseLong(p)) answer++;
        }
        return answer;
    }
}