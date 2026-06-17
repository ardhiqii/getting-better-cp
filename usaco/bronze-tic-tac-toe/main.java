import java.util.*;
import java.io.*;
import java.math.*;
public class main{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("tttt.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
    HashSet<String> single = new HashSet<>();
    HashSet<String> duo = new HashSet<>();
    
    HashSet<String> hsL = new HashSet<>();
    HashSet<String> hsR = new HashSet<>();

    String[][] tictac=new String[3][3];
    for(int i = 0; i < 3;i++){
      tictac[i] = in.readLine().split("");
    }
    in.close();

    for(int i =0 ;i < 3;i++){
      HashSet<String> hmRow = new HashSet<>();
      HashSet<String> hmCol = new HashSet<>();
      hsL.add(tictac[i][i]);
      hsR.add(tictac[i][2-i]);

      for(int j = 0; j < 3;j++){
        String curr = tictac[i][j];
        hmRow.add(curr);

        String currCol = tictac[j][i];
        hmCol.add(currCol);
      }
      ArrayList<String> tmp = new ArrayList<>(hmRow);
      Collections.sort(tmp);
      if(hmRow.size() == 1) single.add(String.join("",tmp));
      if(hmRow.size() == 2) duo.add(String.join("",tmp));
      tmp.clear();
      tmp = new ArrayList<>(hmCol);
      Collections.sort(tmp);
      if(hmCol.size() == 1) single.add(String.join("",tmp));
      if(hmCol.size() == 2) duo.add(String.join("",tmp));
      tmp.clear();
    }
    ArrayList<String> tmp = new ArrayList<>(hsL);
    Collections.sort(tmp);
    if(hsL.size() == 1) single.add(String.join("",tmp));
    if(hsL.size() == 2) duo.add(String.join("",tmp));
    tmp.clear();

    tmp = new ArrayList<>(hsR);
    Collections.sort(tmp);
    if(hsR.size() == 1) single.add(String.join("",tmp));
    if(hsR.size() == 2) duo.add(String.join("",tmp));

    out.println(single.size());
    out.println(duo.size());
    out.close();
  }
}