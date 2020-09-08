package PA01;
import java.util.Scanner;

public class No4 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int[] sub_arr = new int[N];
    static int min=1000;    // 이 부분 너무 좀... 그거 함 // 밑에 리플에 올린 코드 따로 있는데 나중에 다시 함 보기
    static int index = 0;

    public static void main(String[] args) {
        int A = N;
        int[] an = new int[N];
        input_recursion(N, A, an);

        int K = sc.nextInt();

        sub_func(N, A, an, K);
        nearest(N, A, an);

        System.out.println(an[index]);
    }

    private static void input_recursion(int N, int A, int[] an) {
        if (N == 0)
            return;
        else {
            an[A - N] = sc.nextInt();
            input_recursion(N - 1, A, an);
        }
    }

    private static void sub_func(int N, int A, int[] an, int K) {
        int sub = 0;
        if (N == 0)
            return;
        else {
            sub = K - an[A - N];
            if (sub < 0)
                sub = -sub;
            sub_arr[A - N] = sub;
            sub_func(N - 1, A, an, K);
        }
    }

    private static int nearest(int N, int A, int[] an) {
        if (N == 0){
            return index;
        }
        else {
            if (min > sub_arr[A - N]) {
                min = sub_arr[A - N];
                index = A - N;
            } else if (min == sub_arr[A - N]) {
                if (min > an[A - N]) {
                    min = an[A - N];
                    index = A - N;
                }
            }
            nearest(N - 1, A, an);
        }
        return index;
    }
}

/*
// 리플에 올린 코드
* import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int[] sub_arr = new int[N];
    static int min=0;
    static int index = 0;

    public static void main(String[] args) {
        int A = N;
        int[] an = new int[N];
        input_recursion(N, A, an);

        int K = sc.nextInt();

        sub_func(N, A, an, K);
        min=sub_arr[A-N];
        nearest(N, A, an);

        System.out.println(an[index]);
    }

    private static void input_recursion(int N, int A, int[] an) {
        if (N == 0)
            return;
        else {
            an[A - N] = sc.nextInt();
            input_recursion(N - 1, A, an);
        }
    }

    private static void sub_func(int N, int A, int[] an, int K) {
        int sub = 0;
        if (N == 0)
            return;
        else {
            sub = K - an[A - N];
            if (sub < 0)
                sub = -sub;
            sub_arr[A - N] = sub;
            sub_func(N - 1, A, an, K);
        }
    }

    private static int nearest(int N, int A, int[] an) {
        if (N == 1){
            return index;
        }
        else {
            if (min > sub_arr[A - N+1]) {
                min = sub_arr[A - N+1];
                index = A - N+1;
            } else if (min == sub_arr[A - N+1]) {
                if (min > an[A - N+1]) {
                    min = an[A - N+1];
                    index = A - N+1;
                }
            }
            nearest(N - 1, A, an);
        }
        return index;
    }
}

* */