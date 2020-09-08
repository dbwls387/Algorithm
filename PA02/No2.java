package PA02;
import java.util.Scanner;

public class No2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int[][] maze = new int[N][N];
        int x=0,y=0;

        for (int i = 0; i < N; i++) {
            for(int j=0;j<N;j++){
                maze[i][j]=sc.nextInt();
            }
        }
        if(maze_rec(maze, N, x, y)==1)     //탈출 성공
            System.out.println("Yes");
        else                               //탈출 실패
            System.out.println("No");
    }
    static int r=0,d=0,u=0;
    static int cnt=0;
    private static int maze_rec(int [][]maze, int N, int x, int y) {
        if (x == N - 1 && y == N - 1){
            return 1;
        }
        for(int i=0;i<N;i++){
            if(maze[i][0]==1)
                cnt++;
            if(maze[0][i]==1)
                cnt++;
        }
        if(cnt==0){
            for(int i=0;i<N;i++){
                if(maze[i][N-1]==1)
                    cnt++;
                if(maze[N-1][i]==1)
                    cnt++;
            }
            if(cnt>0)
                return 0;
        }
        if ((x==N-1)||(maze[x + 1][y] == 1)) {    //남
            r=1; d=0; u=0;
            return maze_rec(maze, N, x, y + 1);
        }
        else if((y==N-1)||(maze[x][y+1]==1)) {    //동
            r=0; d=1; u=0;
            return maze_rec(maze,N,x+1,y);
        }
        else if(x==0&&y==0){
            r=1; d=0; u=0;
            return maze_rec(maze,N,x,y+1);
        }
        else if((x!=0)&&(maze[x-1][y]==1)){      //북
            if(y==N-1) {
                r=0; d=1; u=0;
                return maze_rec(maze, N, x+1, y);
            }
            else {
                r=1; d=0; u=0;
                return maze_rec(maze, N, x, y+1);
            }
        }
        else if(y==N-1){
            r=0; d=1; u=0;
            return maze_rec(maze, N, x + 1, y);
        }
        if(r==1){
            return maze_rec(maze,N,x,y+1);
        }
        else if(d==1){
            return maze_rec(maze, N, x+1, y);
        }
        else if(u==1) {
            return maze_rec(maze, N, x-1, y);
        }
        return 0;
    }
}