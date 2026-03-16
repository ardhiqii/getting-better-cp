import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class main{

  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int N = sc.nextInt();
    int K = sc.nextInt();
    sc.nextLine();
    char[][] res = new char[M*K][N*K];
    int idxM = 0;
    for(int i = 0; i < M; i++){
      char[] arr = new char[N*K];
      String[] row = sc.nextLine().split("");
      int idx = 0;
      for(int j = 0; j < N;j++){
        char curr = row[j].charAt(0);
        for(int k = 0; k < K; k++){
          arr[idx] = curr;
          idx++;
        }
      }
      for(int k = 0; k < K; k++){
        res[idxM] = arr;
        idxM++;
      }
    }
    for(int i=0; i < M*K; i++){
      String str = new String(res[i]);
      System.out.println(str);
    }
    sc.close();
  }
}