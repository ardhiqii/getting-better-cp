import java.util.*;
import java.io.*;
import java.math.*;


public class main{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("blocks.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
    HashMap<Character,Integer> hm = new HashMap<>();
    int N = Integer.parseInt(in.readLine());
    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(in.readLine());
      HashSet<Character> hs = new HashSet<>();
      HashMap<Character,Integer> hl = new HashMap<>();
      HashMap<Character,Integer> hr = new HashMap<>();
      String left = st.nextToken();
      String right = st.nextToken();
      for(int j = 0; j < left.length(); j++){
        char curr = left.charAt(j);
        hl.put(curr,hl.getOrDefault(curr,0)+1);
        hs.add(curr);
      }
      for(int j = 0; j < right.length(); j++){
        char curr = right.charAt(j);
        hr.put(curr,hr.getOrDefault(curr,0)+1);
        hs.add(curr);
      }
      Iterator<Character> it = hs.iterator();
      while(it.hasNext()){
        char curr = it.next();
        int max = Math.max(hl.getOrDefault(curr,0),hr.getOrDefault(curr,0));
        hm.put(curr,hm.getOrDefault(curr,0)+max);
      }
    }
    in.close();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    for(int i =0 ;i < alphabet.length();i++){
      char curr = alphabet.charAt(i);
      if(hm.containsKey(curr)){
        out.println(hm.get(curr));
      }else{
        out.println(0);
      }
    }
    out.close();
  }
}