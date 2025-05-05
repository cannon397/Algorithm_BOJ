import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a, b) -> convertIntTime(a[0]) - convertIntTime(b[0]));
        ArrayList<ArrayList<int[]>> roomList = new ArrayList<>();
        for(String[] book : book_time){
            int entry = convertIntTime(book[0]);
            int end = convertIntTime(book[1]) + 10;
            boolean assigned = false;
            for(ArrayList<int[]> room: roomList){
                boolean canBook = true;
                for(int[] time : room){
                    if(entry < time[1] && end > time[0]) {
                        canBook = false;
                        break;
                    }
                }
                if(canBook) {
                    room.add(new int[]{entry, end});
                    assigned = true;
                    break;
                }
            }
            if(!assigned) {
                ArrayList<int[]> newRoom = new ArrayList<>();
                newRoom.add(new int[]{entry, end});
                roomList.add(newRoom);
            }
        }
        return roomList.size();
    }
    public int convertIntTime(String time){
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return (hour * 60) + minute;
    }
}