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
    int[] limit = new int[100];
    int idx = 0;
    int cuml = 0;
    for(int i = 0; i < N; i++){
      int[] limitSegs = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      cuml+= limitSegs[0];
      for(int j = idx; j < cuml; j++){
        limit[j] = limitSegs[1];
      }
      idx+= limitSegs[0];
    }

    idx = 0;
    cuml=0;
    int[] bessie = new int[100];
    for(int i = 0; i < N; i++){
      int[] limitSegs = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      cuml+= limitSegs[0];
      for(int j = idx; j < cuml; j++){
        bessie[j] = limitSegs[1];
      }
      idx+= limitSegs[0];
    }
    int max = 0;
    for(int i = 0; i < 100; i++){
      max = Math.max(max,(bessie[i] - limit[i]));
    }
    out.println(max);
    out.close();
  }
}