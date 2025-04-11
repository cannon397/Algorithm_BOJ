class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] gather = {"aya", "ye", "woo", "ma"};
        for(String s : babbling){
            String temp = s;
            String condition = "";
            
            for(int i = 0; i < gather.length; i++){
                if(condition.equals(gather[i])) continue;
                if(temp.length() == 0 ) {
                    answer++; 
                    break;
                }
                if(temp.indexOf(gather[i]) == 0){
                    condition = gather[i];
                    temp = temp.replaceFirst(gather[i], "");
                    i = -1;
                }
            }
        }
        return answer;
    }
}