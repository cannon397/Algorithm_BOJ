class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        for(int i = 0; i < schedules.length; i++){
            boolean flag = true;
            for(int j = 0; j < timelogs[i].length; j++){
                if((startday + j - 1) % 7 < 5){
                    int mok = (schedules[i] + 10) / 100;
                    int temp = ((schedules[i] + 10) - (100 * mok)) / 60;            
                    int mod = ((schedules[i] + 10) - (100 * mok)) % 60;      
                    mok += temp;
                    int condition = mok * 100 + mod;
                    if(condition < timelogs[i][j]){
                        System.out.println(timelogs[i][j]);
                        flag = false;
                    }
                }
            }
            if(!flag) answer--;
        }
        return answer;
    }
}