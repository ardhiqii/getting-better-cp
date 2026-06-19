import java.util.*;
import java.io.*;
import java.math.*;

public class main{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("badmilk.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    ArrayList<Integer>[] milk = new ArrayList[M+1];
    ArrayList<Integer>[] susMilk = new ArrayList[M+1];
    HashMap<Integer,ArrayList<Integer>>[] timePersonMilk = new HashMap[101];
    for(int i = 0; i <D; i++){
      st = new StringTokenizer(in.readLine());
      int p = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());

      if(milk[m] == null) milk[m] = new ArrayList<>();
      if(!milk[m].contains(p))milk[m].add(p);
      

      if(timePersonMilk[t] == null) timePersonMilk[t] = new HashMap<>();
      if(!timePersonMilk[t].containsKey(p)) timePersonMilk[t].put(p,new ArrayList<>());
      ArrayList<Integer> tmp = timePersonMilk[t].get(p);
      tmp.add(m);
      timePersonMilk[t].put(p,tmp);
    }


    for(int i =0 ; i < S; i++){
      st = new StringTokenizer(in.readLine());
      int p = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      for(int t = time-1; t >0; t--){
        if(timePersonMilk[t] != null && timePersonMilk[t].containsKey(p)){
          ArrayList<Integer> tmp = timePersonMilk[t].get(p);
          for(int m : tmp){
            if(susMilk[m] == null) susMilk[m] = new ArrayList<>();
            if(!susMilk[m].contains(p)) susMilk[m].add(p);
          }
        }
      }
    }

    int res = 0;
    ArrayList<Integer> targetMilk = new ArrayList<>();
    for(int m = 1; m  <= M;m++){
      if(susMilk[m] == null) continue;
      if(susMilk[m].size() == S) targetMilk.add(m);
    }
    for(int m : targetMilk){
      res = Math.max(milk[m].size(),res);
    }
    out.println(res);
    in.close();
    out.close();
  }
}