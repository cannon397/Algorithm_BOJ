
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skill_tree : skill_trees){
            String temp = skill_tree.replaceAll("[^"+skill+" ]","");
            if(temp.length() > 0 && skill.charAt(0) == temp.charAt(0) && skill.contains(temp)) answer++;
            if(temp.length() == 0) answer++;
            System.out.println(temp);
        }
        return answer;
    }
}