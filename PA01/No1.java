package PA01;
import java.util.Scanner;

public class No1 {
    static Scanner sc=new Scanner(System.in);
    static int cnt=1;
    public static void main(String[] args) {
        int N=sc.nextInt();
        int A=N;
        int []an =new int[N];
        input_recursion(N, A, an);

        int x=sc.nextInt();
        com_recursion(N, A, x, an);

        System.out.println(cnt);
    }
    private static void input_recursion(int N, int A, int []an){
        if(N==0)
            return;
        else {
            an[A-N]=sc.nextInt();
            input_recursion(N-1, A, an);
        }
    }
    private static void com_recursion(int N, int A, int x, int []an){
        if(N==0)
            return;
        else{
            if(an[A-N]<x)
                cnt++;
            com_recursion(N-1, A, x, an);
        }
    }
}