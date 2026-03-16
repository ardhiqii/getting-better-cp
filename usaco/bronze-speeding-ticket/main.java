import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class main{

  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("input.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer st = new StringTokenizer(in.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
  
    int[] seg = new int[N];
    int[] sp = new int[N];
    int count = 0;
    for(int i = 0; i < N;i++){
      st = new StringTokenizer(in.readLine());
      count+= Integer.parseInt(st.nextToken());
      seg[i] = count;
      sp[i] = Integer.parseInt(st.nextToken());
    }

    int idx = 0;
    int max = 0;
    count = 0;
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(in.readLine());
      int addSegment = Integer.parseInt(st.nextToken());
      int speed = Integer.parseInt(st.nextToken());
      if(count <= seg[idx]){
        max = Math.max(max,(speed-sp[idx]));
      }
      count+= addSegment;
      if(count > seg[idx]){
        idx++;
      }
      if(count <= seg[idx]){
        max =  Math.max(max,(speed-sp[idx]));
      }
    }
    out.println(max);
    out.close();
  }
}