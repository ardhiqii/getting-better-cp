import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class main{

  public static void main(String[] args) throws IOException{
    /*
    ### STILL WRONG COZ THIS ASSUME "Y" POSITION ALWAYS ON THE RIGHT SIDE OF "X" ###
    ### ME JUST LEARN FROM ORIGIN SOLUTION                                       ###
    */
    BufferedReader in = new BufferedReader(new FileReader("input.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer st = new StringTokenizer(in.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    int posx = x;
    int dir = 1;
    int d = 1;
    int total = 0;
    
    while(true){
      if(posx >= y){
        total-= Math.abs(posx-y);
        break;
      }
      if(dir == 1 && posx < y){
        total+= Math.abs((x+d) - posx);
        posx = x+d;
        d*=2;
        dir*=-1;
      }else{
        total+= Math.abs((x-d) - posx);
        posx = x-d;
        d*=2;
        dir*=-1;
      }
    }

    out.println(total);
    out.close();
  }
}