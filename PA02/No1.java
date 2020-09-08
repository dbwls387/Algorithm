package PA02;
import java.util.Scanner;

public class No1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int[][] maze = new int[N][N];
        int x = 0, y = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        int K = sc.nextInt();
        int K_cnt = 0;

        find_maze(maze, N, x, y, K, K_cnt);

        System.out.println(cnt);
    }

    static int cnt = 0;

    // 0:갈 수 있는 길, 1:벽, 3:지나온 길
    private static int find_maze(int[][] maze, int N, int x, int y, int K, int K_cnt) {
        if (x < 0 || y < 0 || x >= N || y >= N || maze[x][y] != 0) {
            return 0;   //false
        }
        else if (K_cnt > K) {
            return 0;
        }
        else if (x == N - 1 && y == N - 1) {
            cnt++;
            maze[x][y]=0;

            return 1;   //true
        }
        else {
            maze[x][y] = 3;
            find_maze(maze, N, x - 1, y, K, K_cnt+1);
            find_maze(maze, N, x, y + 1, K,K_cnt+1);
            find_maze(maze, N, x + 1, y, K,K_cnt+1);
            find_maze(maze, N, x, y - 1, K,K_cnt+1);
        }
        maze[x][y]=0;
        return 1;
    }
}