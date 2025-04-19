import java.util.*;
class Solution {
    boolean[] visited;
    ArrayList<Integer> indexList; //답안 제출용
    HashMap<String, Integer> map;
    int wLength = 1;
    public int[] solution(String msg) {
        int[] answer = {};
        indexList = new ArrayList<>();
        map = new HashMap<>();
        visited = new boolean[msg.length()];
        for(int i = 0; i < 26; i++){
            char c = (char)('A' + i);
            String s = String.valueOf(c);
            map.put(s, i + 1);
        }
        
        dfs(msg, "", 0, -1);
        //System.out.println(map);
        answer = indexList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    public void dfs(String msg, String w, int start, int lastIndex){
        if(start == msg.length()) {
            indexList.add(map.get(w));
            return;
        }
            
        for(int i = start; i < msg.length(); i++){
            if(visited[i]) continue;
            char c = msg.charAt(i);
            String s = w + String.valueOf(c);   
            
            if(lastIndex != -1 && i - lastIndex > 1) return;
            if(map.containsKey(s)){
                visited[i] = true;
                dfs(msg, s, i + 1, i);
            }else{
                indexList.add(map.get(w));
                map.put(s, map.size() + 1);
                return;
            }
        }
        return;
    }
}