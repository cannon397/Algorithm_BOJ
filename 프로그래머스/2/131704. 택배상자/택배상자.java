import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subBelt = new Stack<>();
        int mainBelt = 1;
        int index = 0;
        while(mainBelt <= order.length){
            if(order[index] != mainBelt){
                subBelt.push(mainBelt);
                mainBelt++;  
            }else{
                index++;
                answer++;
                mainBelt++;
            }

            while(!subBelt.isEmpty() && subBelt.peek() == order[index]){
                subBelt.pop();
                answer++;
                index++;
            }

        }
        //System.out.println(subBelt);
        return answer;
    }
}