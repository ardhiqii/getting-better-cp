import java.util.*;
import java.io.*;
import java.math.*;

public class main{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("mowing.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
    int N = Integer.parseInt(in.readLine());
    HashMap<ArrayList<Integer>, Integer> hm = new HashMap<>();
    int res = Integer.MAX_VALUE;
    int x = 0;
    int y = 0;
    int time = 0;
    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(in.readLine());
      String d = st.nextToken();
      int s = Integer.parseInt(st.nextToken());
      for(int j =1; j <=s;j++){
        switch(d){
          case "N":
            y+=1;
            break;
          case "S":
            y-=1;
            break;
          case "W":
            x-=1;
            break;
          case "E":
            x+=1;
            break;
          default:
            break;
        }
        time++;
        ArrayList<Integer> coor = new ArrayList<>(List.of(x,y));
        if(hm.containsKey(coor)){
          res = Math.min(time-hm.get(coor),res);
        }
        hm.put(coor,time);
      }
    }
    in.close();
    if(res == Integer.MAX_VALUE)res=-1;
    out.println(res);
    out.close();
  }
}