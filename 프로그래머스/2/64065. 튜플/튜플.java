import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] numbers = s.replace("{","").replace("}","").split(",");
        for(String number : numbers){
            int n = Integer.parseInt(number);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        answer = new int[map.size()];
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        for(int i = 0; i < answer.length; i++){
            answer[answer.length - list.get(i).getValue()] = list.get(i).getKey();
        }
        return answer;
    }
}