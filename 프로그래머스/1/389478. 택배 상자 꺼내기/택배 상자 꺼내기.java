import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for(int i = 0; i < w; i++){
            list.add(new LinkedList<>());
        }
        int i = 0;       
        int temp = 0;
        while(n > i){
            if((i / w) % 2 == 0){
                list.get(i % w).add(i + 1);
            }else{
                list.get(w - 1 - (i % w)).add(i + 1);
            }
            i++;
        }
        System.out.println(list);
        for(int j = 0; j < list.size(); j++){
            int answer_temp = 0;
            boolean flag = true;
            while(!list.get(j).isEmpty()){
                if(list.get(j).poll() == num){
                    System.out.println(num);
                    answer_temp = 0;
                    flag = false;
                }
                answer_temp++;
            }
            if(!flag){
                answer = answer_temp;
                break;
            }
        }
        return answer;
    }
}