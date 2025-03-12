import java.util.*;
class Solution {
public int[] solution(int[][] edges) {
    // 정점, 도넛, 막대, 8자
    int[] answer = new int[4];
    HashMap<Integer,Vertex> map = new HashMap<>();
    for(int i = 0; i < edges.length; i++){
        int from = edges[i][0];
        int to = edges[i][1];

        if(!map.containsKey(from)){
            Vertex vertex = new Vertex();
            vertex.V = from;
            vertex.out++;
            map.put(from,vertex);
        }else{
            map.get(from).out++;
        }
        if(!map.containsKey(to)){
            Vertex vertex = new Vertex();
            vertex.V = to;
            vertex.in++;
            map.put(to,vertex);
        }else{
            map.get(to).in++;
        }
    }
    map.forEach((key,value)->{
       if(value.out == 2 && value.in >= 2){
           answer[3]++;
       }else if(value.out >= 2 && value.in == 0){
           answer[0] = value.V;
           answer[1] = value.out;
       }else if(value.out == 0 && value.in >= 1){
           answer[2]++;
       }
    });
    answer[1] -= (answer[2] + answer[3]);
    return answer;
    }    
}
class Vertex{
    int V;
    int in;
    int out;
}
