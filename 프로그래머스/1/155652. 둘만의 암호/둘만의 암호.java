import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(char c : skip.toCharArray()){
            set.add(c);
        }
        for (char c : s.toCharArray()) {
            for (int i = 0; i < index; i++) {
                do {
                    c = (char) ((c - 'a' + 1) % 26 + 'a');
                } while (set.contains(c));
            }
            answer.append(c);
        }
        return answer.toString();
    }
}