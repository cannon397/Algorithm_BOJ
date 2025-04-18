class Solution {
    String[] vowels = {"A", "E", "I", "O", "U"};
    int answer = 0;
    boolean found = false;
    public int solution(String word) {
        
        
        dfs("", word);
        return answer;
    }
    public void dfs(String current,String target){
        if(found) return;
        if(current.length() > 0) answer++;
        if(current.equals(target)) {
            found = true;
            return;
        }
        for(int i = 0; i < vowels.length; i++){
            String s = current + vowels[i];
            if(s.length() > 5) return;
            dfs(s, target);
        }
    }
}