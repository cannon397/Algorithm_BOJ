import java.util.*;
class Solution {
    HashMap<Character, Integer> map;
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        map = new HashMap<>();
        for(int i = 0; i < survey.length; i++){
            if(choices[i] == 4){
                continue;
            }
            int score = 0;
            if(choices[i] > 4){
                score = choices[i] - 4;
                char c = survey[i].charAt(1);
                map.put(c, map.getOrDefault(c, 0) + score);
            }
            if(choices[i] < 4){
                score = 4 - choices[i];
                char c = survey[i].charAt(0);
                map.put(c, map.getOrDefault(c, 0) + score);
            }
        }
        answer += getPersonality('R','T');
        answer += getPersonality('C','F');
        answer += getPersonality('J','M');
        answer += getPersonality('A','N');
        return answer;
    }
    public String getPersonality(char a, char b){
        String answer = "";
        if(map.getOrDefault(a, 0) >= map.getOrDefault(b, 0)){
            answer += String.valueOf(a);
        }else {
            answer += String.valueOf(b);
        }
        return answer;
    }
}