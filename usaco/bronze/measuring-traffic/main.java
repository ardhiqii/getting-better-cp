import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class main{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("traffic.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));

    int N = Integer.parseInt(in.readLine());
    int[] onRamps ={Integer.MIN_VALUE,Integer.MAX_VALUE};
    int[] offRamps ={Integer.MIN_VALUE,Integer.MAX_VALUE};
    int[] highways ={Integer.MIN_VALUE,Integer.MAX_VALUE};
    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(in.readLine());
      String type = st.nextToken();
      int low = Integer.parseInt(st.nextToken());
      int high = Integer.parseInt(st.nextToken());
      switch (type){
        case "none":
          highways[0] = Math.max(highways[0],low);
          highways[1] = Math.min(highways[1],high);
          break;
        case "on":
          onRamps[0] = Math.max(onRamps[0],low);
          onRamps[1] = Math.min(onRamps[1],high);
          break;
        default:
          offRamps[0] = Math.max(offRamps[0],low);
          offRamps[1] = Math.min(offRamps[1],high);
          break;
      }
    }
    in.close();
    onRamps[0] = onRamps[0] == Integer.MIN_VALUE ? 0 : onRamps[0];
    onRamps[1] = onRamps[1] == Integer.MAX_VALUE ? 1 : onRamps[1];
    offRamps[0] = offRamps[0] == Integer.MIN_VALUE ? 0 : offRamps[0];
    offRamps[1] = offRamps[1] == Integer.MAX_VALUE ? 0 : offRamps[1];
    int l1 = highways[0] - onRamps[0];
    int h1 = highways[1] - onRamps[1];
    int l2 = highways[0] - offRamps[1];
    int h2 =highways[1] - offRamps[0];
    l1 = l1 < 0 ? 0 : l1;
    l2 = l2 < 0 ? 0 : l2;
    out.printf("%d %d\n",l1,h1);
    out.printf("%d %d\n",(highways[0] - offRamps[1]),(highways[1] - offRamps[0]));
    out.close();
  }
}