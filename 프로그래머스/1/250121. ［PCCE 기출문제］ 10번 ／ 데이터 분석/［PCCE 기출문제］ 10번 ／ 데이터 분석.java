import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;
        ArrayList<int[]> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);
        for(int i = 0; i < data.length; i++){
            int index = map.get(ext);
            if(data[i][index] < val_ext){
                list.add(data[i]);
            }
        }
        Collections.sort(list, (o1, o2)->{
            int index = map.get(sort_by);
            return o1[index] - o2[index];
        });
        answer = new int[list.size()][];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}