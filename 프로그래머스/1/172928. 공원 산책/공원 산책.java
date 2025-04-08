class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[] startPos = new int[2];
        int row = park.length;
        int col = park[0].length();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(park[i].charAt(j) == 'S'){
                    startPos[0] = i;
                    startPos[1] = j;
                    park[i] = park[i].replace("S","O");
                }
            }
        }
        for(int i = 0; i < routes.length; i++){
            String[] route = routes[i].split(" ");
            String direction = route[0];
            int distance = Integer.parseInt(route[1]);
            int[] tempPos = {startPos[0], startPos[1]};
            int flag = 0;
            for(int j = 1; j <= distance; j++){
                
                if(direction.equals("E") && col > startPos[1] + j && park[startPos[0]].charAt(startPos[1] + j) == 'O'){
                    tempPos[1]++;
                    flag++;
                }
                if(direction.equals("W") && 0 <= startPos[1] - j && park[startPos[0]].charAt(startPos[1] - j) == 'O'){
                    tempPos[1]--;
                    flag++;
                }
                if(direction.equals("S") && row > startPos[0] + j && park[startPos[0] + j].charAt(startPos[1]) == 'O'){
                    tempPos[0]++;
                    flag++;
                }
                if(direction.equals("N") && 0 <= startPos[0] - j && park[startPos[0] - j].charAt(startPos[1]) == 'O'){
                   tempPos[0]--;
                    flag++;
                }
                if(flag == distance && distance == j){
                   startPos[0] = tempPos[0];
                   startPos[1] = tempPos[1];
                }
            }
        }
        answer = startPos;
        return answer;
    }
}