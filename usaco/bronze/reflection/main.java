import java.util.*;
import java.math.*;
import java.io.*;

public class main{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int U = Integer.parseInt(st.nextToken());

    char[][] painting = new char[N][N];
    for(int i= 0; i < N;i++){
      String row = in.readLine();
      for(int j=0; j < N;j++){
        painting[i][j] = row.charAt(j);
      }
    }
    int op = 0;
    for(int i =0; i < N/2;i++){
      for(int j =0; j < N/2;j++){
        op += minOperation(painting,N,i,j);
      }
    }
    out.println(op);

    
    while(U-- > 0){
      st = new StringTokenizer(in.readLine());
      int i = Integer.parseInt(st.nextToken())-1;
      int j = Integer.parseInt(st.nextToken())-1;
      op-= minOperation(painting,N,i,j);
      painting[i][j] = painting[i][j] == '.' ? '#' : '.';
      op+= minOperation(painting,N,i,j);
      out.println(op);
    }
    in.close();
    out.close();
  }

  static int minOperation(char[][] painting, int N, int i,int j){
    int op = 0;
      int dot = 0;
      int hashtag = 0;
        char tl = painting[i][j];
        char tr = painting[i][N-j-1];
        char bl = painting[N-i-1][j];
        char br = painting[N-i-1][N-j-1];
        if(tl == '.') dot++;
        if(tl != '.') hashtag++;

        if(tr == '.') dot++;
        if(tr != '.') hashtag++;

        if(bl == '.') dot++;
        if(bl != '.') hashtag++;

        if(br == '.') dot++;
        if(br != '.') hashtag++;
        op += Math.min(dot,hashtag);
    return op;
  }
}