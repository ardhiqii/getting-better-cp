import java.util.*;
import java.math.*;
import java.io.*;

public class main{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("cbarn.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));

    int N = Integer.parseInt(in.readLine());

    int[] rooms = new int[N];
    for(int i =0 ;i < N; i++){
      rooms[i] = Integer.parseInt(in.readLine());
    }
    in.close();
    int res = Integer.MAX_VALUE;
    for(int i = 0; i < N;i++){
      int tmp = 0;
      int door = i;
      for(int j = 0; j < N; j++){
        if(door == N) door = 0;
        tmp += rooms[door] * j;
        door++;
      }
      res = Math.min(res,tmp);
    }
    out.println(res);
    out.close();
    
  }
}