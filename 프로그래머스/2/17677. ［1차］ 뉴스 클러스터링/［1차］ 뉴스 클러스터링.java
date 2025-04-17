import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> map1 = parseStringToMap(str1);
        Map<String, Integer> map2 = parseStringToMap(str2);
        Set<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());


        
        int intersection = 0;
        int union = 0;
        for (String key : set) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
        if (union == 0) return 65536;
        answer = (int) (((float) intersection / union) * 65536);
        return answer;
    }
    public void putAllList(HashMap<String, Integer> map, ArrayList<String> list){
        for(int i = 0; i < list.size(); i++){
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
        }
    }
    public Map<String, Integer> parseStringToMap(String str){
        str = str.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length() - 1; i++){
            int end = Math.min(i + 2, str.length());
            String s = str.substring(i, end);
            if(s.matches("[a-zA-Z]+")) map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }
}
