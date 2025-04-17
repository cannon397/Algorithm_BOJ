import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        HashMap<Integer, Integer> map = new HashMap<>();
        s = s.replace("{","");
        s = s.replace("}","");
        String[] numbers = s.split(",");
        StringBuilder sb = new StringBuilder();
        for(String number : numbers){
            int n = Integer.parseInt(number);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        answer = new int[map.size()];
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i).getKey();
        }
        return answer;
    }
}