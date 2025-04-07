import java.util.*;
class Solution {
    int videoSeconds;
    int posSeconds;
    int currentPositionSeconds;
    int startSeconds;
    int endSeconds;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] videoSplit = video_len.split(":");
        String[] posSplit = pos.split(":");
        String[] startSplit = op_start.split(":");
        String[] endSplit = op_end.split(":");
        int videoMinute = Integer.parseInt(videoSplit[0]);
        int posMinute = Integer.parseInt(posSplit[0]);
        int startMinute = Integer.parseInt(startSplit[0]);
        int endMinute = Integer.parseInt(endSplit[0]);
        videoSeconds = Integer.parseInt(videoSplit[1]);
        posSeconds = Integer.parseInt(posSplit[1]);
        startSeconds = Integer.parseInt(startSplit[1]);
        endSeconds = Integer.parseInt(endSplit[1]);
        
        videoSeconds += (videoMinute * 60);
        posSeconds += (posMinute * 60);
        startSeconds += (startMinute * 60);
        endSeconds += (endMinute * 60);
        currentPositionSeconds = posSeconds;
        
        moveVideoTime("");
        for(String command : commands){
            answer = moveVideoTime(command);
        }
        return answer;
    }
    public String moveVideoTime(String command){
        
        switch(command){
            case "":
                if(currentPositionSeconds >= startSeconds && currentPositionSeconds <= endSeconds){
                    currentPositionSeconds = endSeconds;
                }
                break;
            case "next":
                currentPositionSeconds += 10;
                if(currentPositionSeconds > videoSeconds){
                    currentPositionSeconds = videoSeconds;
                }
                break;
            case "prev":
                currentPositionSeconds -= 10;
                if(currentPositionSeconds < 0){
                    currentPositionSeconds = 0;
                }
                break;
        }

        if(currentPositionSeconds >= startSeconds && currentPositionSeconds <= endSeconds){
            currentPositionSeconds = endSeconds;
        }
        int updatedMinute = currentPositionSeconds / 60;
        int updatedSeconds = currentPositionSeconds % 60;
        return String.format("%02d:%02d",updatedMinute, updatedSeconds);
    }
}