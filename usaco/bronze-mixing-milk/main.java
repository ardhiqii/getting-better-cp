import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] cap = new int[3];
    int[] milk = new int[3];
    for(int i =0; i < 3; i++){
      cap[i] = sc.nextInt();
      milk[i] = sc.nextInt();
      sc.nextLine();
    }
    sc.close();
    for(int i = 0; i < 100; i++){
      int currentIndex = i%3;
      int nextIndex = (i+1)%3;
      int total = milk[currentIndex] + milk[nextIndex];
      int newCurrentMilk = 0;
      int newNextMilk = total;
      if(total > cap[nextIndex]){
        newCurrentMilk = total - cap[nextIndex];
        newNextMilk = cap[nextIndex];
      }
      milk[currentIndex] = newCurrentMilk;
      milk[nextIndex] = newNextMilk; 
    }
    System.out.println(milk[0]);
    System.out.println(milk[1]);
    System.out.println(milk[2]);
  }
}