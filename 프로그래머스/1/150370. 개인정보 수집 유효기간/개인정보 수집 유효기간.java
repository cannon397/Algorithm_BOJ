import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms){
            String[] inform = term.split(" ");
            map.put(inform[0], Integer.parseInt(inform[1]));
        }
        for(int i = 0; i < privacies.length; i++){
            String[] inputData = privacies[i].split(" ");
            String[] parts = inputData[0].split("\\.");
            int totalDays = convertDateFormatToDays(parts[0], parts[1], parts[2]);
            int monthToDay = map.get(inputData[1]) * 28;
            int expireDay = totalDays + monthToDay;
            String[] todayParts = today.split("\\.");
            int convertedToday = convertDateFormatToDays(todayParts[0], todayParts[1], todayParts[2]);
            if(convertedToday >= expireDay) list.add(i + 1);
        }
        return list;
    }
    public int convertDateFormatToDays(String year, String month, String day){
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        return (y * 12 * 28) + ((m - 1) * 28) + d;
    }
}