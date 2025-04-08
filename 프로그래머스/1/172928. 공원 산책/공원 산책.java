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
            int moveY = startPos[0];
            int moveX = startPos[1];
            int flag = 0;
            for(int j = 1; j <= distance; j++){
                switch(direction){
                    case "N":
                        moveY--;
                        break;
                    case "S":
                        moveY++;
                        break;
                    case "E":
                        moveX++;
                        break;
                    case "W":
                        moveX--;
                        break;
                }
                
                if(moveY >= 0 && moveY < row && moveX >= 0 && moveX < col){
                    if(park[moveY].charAt(moveX) == 'X') break;
                    if(distance == j) {
                        startPos[0] = moveY;
                        startPos[1] = moveX;
                    }
                }
            }
        }
        answer = startPos;
        return answer;
    }
}