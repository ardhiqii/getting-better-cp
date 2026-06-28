import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;


public class main{
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("input.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    HashMap<Integer,Integer> bucketMin = new HashMap<>();
    HashMap<Integer,Integer> bucketMax = new HashMap<>();
    HashMap<Integer,Integer> range = new HashMap<>();
    int C = Integer.parseInt(in.readLine());
    int min = Integer.MAX_VALUE;
    int max = 0;
    for(int i = 0; i < C; i++){
      StringTokenizer st = new StringTokenizer(in.readLine());
      int s = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      range.put(s,t);
      bucketMin.put(s,b);
      bucketMax.put(t,b);
      min = Math.min(min,s);
      max = Math.max(max,t);
    }
    int total = 0;
    int used = 0;
    for(int i = min; i <= max; i++){
      if(range.containsValue(i)){
        total-= bucketMax.get(i);
      }
      if(range.containsKey(i)){
        total+=bucketMin.get(i);
        used = Math.max(total,used);
      }
    }
    out.println(used);
    in.close();
    out.close();
  }
}