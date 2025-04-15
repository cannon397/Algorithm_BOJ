import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map1.put(want[i], number[i]);
        }
        HashMap<String, Integer> map2;
        for(int i = 0; i <= discount.length - 10; i++){
            map2 = new HashMap<>();
            for(int j = i; j < i + 10; j++){
                map2.put(discount[j], map2.getOrDefault(discount[j], 0) + 1);
            }
            ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map2.entrySet());
            boolean flag = true;
            for(Map.Entry<String, Integer> entry : list){
                if(map1.get(entry.getKey()) != entry.getValue()) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}