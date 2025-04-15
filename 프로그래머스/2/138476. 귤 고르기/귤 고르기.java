import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int size : tangerine){
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2)-> e2.getValue().compareTo(e1.getValue()));
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : list){
            if(k > sum){
                sum += entry.getValue();
                answer++;
            }else{
                break;
            }
        }

        return answer;
    }
}