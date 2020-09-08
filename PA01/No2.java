package PA01;
import java.util.Scanner;

public class No2 {
    static Scanner sc=new Scanner(System.in);
    static int cnt=1;
    public static void main(String[] args) {
        int N=sc.nextInt();
        int A=N;
        int x=0;
        int B=N;
        int []an =new int[N];
        input_recursion(N, A, an);

        index(N, A, B, x, an);
    }
    private static void input_recursion(int N, int A, int []an){
        if(N==0)
            return;
        else {
            an[A-N]=sc.nextInt();
            input_recursion(N-1, A, an);
        }
    }
    private static void index(int N, int A, int B, int x, int []an){
        if(N==0)
            return;
        else{
            x=an[A-N];
            com_recursion(N, A, B, x, an);
            index(N-1, A, B, x, an);
        }
    }
    private static void com_recursion(int N, int A, int B, int x, int []an){
        if(B==0){
            System.out.print(cnt+" ");
            cnt=1;
            return;}
        else{
            if(an[A-B]<x)
                cnt++;
            com_recursion(N, A, B-1, x, an);
        }
    }
}