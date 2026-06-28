import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class main{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("input.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int C = Integer.parseInt(in.readLine());
    String[] tempArr = in.readLine().split(" ");
    int[] shuffle = new int[C];
    for(int i = 0; i < C; i++){
      shuffle[i] = Integer.parseInt(tempArr[i]);
    }

    tempArr = in.readLine().split(" ");
    int[] positions = new int[C];
    for(int i = 0; i < C; i++){
      positions[i] = Integer.parseInt(tempArr[i]);
    }

    for(int i = 0; i < 3; i++){
      int[] temp = new int[C];
      for(int j = 0; j < C; j++){
        temp[j] = positions[shuffle[j]-1];
      }
      positions = temp;
    }
    out.println(Arrays.toString(positions));
    out.close();
  }
}