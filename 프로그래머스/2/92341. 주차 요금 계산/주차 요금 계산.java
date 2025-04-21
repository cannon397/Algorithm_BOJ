import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int endMinute = convertTimeToInt("23:59");
        int basicTime = fees[0];
        int basicFee = fees[1];
        int extraTime = fees[2];
        int extraFee = fees[3];
        HashMap<String, String> logs = new HashMap<>();
        HashMap<String, Integer> useTimeLogs = new HashMap<>();
        for(String record : records){
            String[] splitRecord = record.split(" ");
            String time = splitRecord[0];
            String carNumber = splitRecord[1];
            String inAndOut = splitRecord[2];
            if(inAndOut.equals("IN")){
                logs.put(carNumber, time);
            }else{
                String entryTime = logs.get(carNumber);
                int useMinute = convertTimeToInt(time) - convertTimeToInt(entryTime); // 이용시간
                logs.remove(carNumber);
                useTimeLogs.put(carNumber, useTimeLogs.getOrDefault(carNumber, 0) + useMinute);
            }
        }
        for(Map.Entry<String, String> entry : logs.entrySet()){
            int useMinute = endMinute - convertTimeToInt(entry.getValue());
            String carNumber = entry.getKey();
            useTimeLogs.put(carNumber, useTimeLogs.getOrDefault(carNumber, 0) + useMinute);
        }
        //System.out.println(useTimeLogs);
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(useTimeLogs.entrySet());
        list.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        answer = new int[list.size()];
        int idx = 0;
        System.out.println(list);
        for(Map.Entry<String, Integer> entry : list){
            int useMinute = entry.getValue();
            if(useMinute > basicTime){
                int remainedMinute = useMinute - basicTime;
                int fee = ((remainedMinute / extraTime) * extraFee) + ((remainedMinute % extraTime > 0) ?extraFee:0);
                answer[idx] = basicFee + fee;
            }else{
                answer[idx] = basicFee;
            }
            idx++;
        }
        return answer;
    }
    public int convertTimeToInt(String sTime){
        String[] splitTime = sTime.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);
        int convertedTime = hour * 60 + minute;
        return convertedTime;
    }
}