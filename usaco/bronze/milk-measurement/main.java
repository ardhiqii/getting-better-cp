import java.util.*;
import java.io.*;
import java.math.*;

public class main{
  static class Pair {
    String name;
    int val;
    Pair(String name, int val) { this.name = name; this.val = val; }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("measurement.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

    HashSet<String> top = new HashSet<>();
    HashMap<String,Integer> leaderboard = new HashMap<>();
    leaderboard.put("Bessie",7);
    leaderboard.put("Elsie",7);
    leaderboard.put("Mildred",7);
    int N = Integer.parseInt(in.readLine());
    int[] measurements = new int[101];
    String[] cows = new String[101];
    while(N-- >0){
      StringTokenizer st = new StringTokenizer(in.readLine());
      int d = Integer.parseInt(st.nextToken());
      String cow = st.nextToken();
      String[] raw = st.nextToken().split("");
      int measure = Integer.parseInt(raw[1]);
      if(raw[0].equals("-")) measure*=-1;
      measurements[d] = measure;
      cows[d] = cow;
    }

    int res = 0;

    for(int i = 1; i <= 100; i++ ){
      if(measurements[i] == 0) continue;
      PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.val,a.val));
      String cow = cows[i];
      int value = measurements[i];

      leaderboard.put(cow,leaderboard.get(cow) + value);
      pq.add(new Pair("Bessie",leaderboard.get("Bessie")));
      pq.add(new Pair("Elsie",leaderboard.get("Elsie")));
      pq.add(new Pair("Mildred",leaderboard.get("Mildred")));

      int max = 0;
      boolean changes = false;
      for(int j = 0; j < 3;j++){
        Pair curr =pq.poll();
        max = Math.max(max,curr.val);
        if(top.contains(curr.name)){
          if(curr.val != max){
            changes = true;
            top.remove(curr.name);
          }
        }else{
          if(curr.val == max){
            changes = true;
            top.add(curr.name);
          }
        }
      }
      if(changes) res++;
    }
    out.println(res);
    in.close();
    out.close();
  }
}