package PA01;
import java.util.Scanner;

public class No3 {
    static Scanner sc = new Scanner(System.in);
    static int cnt = 0;

    public static void main(String[] args) {
        int N = sc.nextInt();
        int A = N;
        int sum = 0;

        int[] an = new int[N];
        input_recursion(N, A, an);

        int K = sc.nextInt();

        int a = 0, b = 1, c = 2;
        com_sum(N, A, K, an, sum, a, b, c);
        System.out.println(cnt);
    }

    private static void input_recursion(int N, int A, int[] an) {
        if (N == 0)
            return;
        else {
            an[A - N] = sc.nextInt();
            input_recursion(N - 1, A, an);
        }
    }

    private static int com_sum(int N, int A, int K, int[] an, int sum, int a, int b, int c) {
        if (a == N - 3) {
            if (b == N - 2)
                if (c == N - 1)
                    return cnt;
        } else {
            sum += an[a];
            sum += an[b];
            sum += an[c];

            if (sum == K) {
                cnt++;
                sum = 0;
                if (A == N - 3) {
                    return cnt;
                } else if (b == N - 2) {
                    a++;
                    b = a;
                    b++;
                    c = b;
                    c++;
                    return com_sum(N, A, K, an, sum, a, b, c);
                } else if (c <= N - 1) {
                    b = b + 1;
                    c = b;
                    c++;
                    return com_sum(N, A, K, an, sum, a, b, c);
                }
            } else {
                sum = 0;
                if (A == N - 3) {
                    return cnt;
                } else if (b == N - 2) {
                    a++;
                    b = a;
                    b++;
                    c = b;
                    c++;
                    return com_sum(N, A, K, an, sum, a, b, c);
                } else if (c == N - 1) {
                    b = b + 1;
                    c = b;
                    c++;
                    return com_sum(N, A, K, an, sum, a, b, c);
                } else if (c < N - 1) {
                    c++;
                    return com_sum(N, A, K, an, sum, a, b, c);
                }
            }
        }
        return cnt;
    }
}