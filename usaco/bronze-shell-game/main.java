import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class main {

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();
    int[] pabble = {0,1,2};
    int[] correct = new int[3];
    while(N-- >0){
      int a = sc.nextInt()-1;
      int b = sc.nextInt()-1;
      int g = sc.nextInt()-1;
      sc.nextLine();

      int temp = pabble[b];
      pabble[b] = pabble[a];
      pabble[a] = temp;
      correct[pabble[g]]++; 
    }
    sc.close();
    int max = Math.max(correct[0],Math.max(correct[1],correct[2]));
    System.out.println(max);
  }

}